/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.docs.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.docs.guestbook.GuestBookNameException;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.EntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.base.GuestBookLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the guest book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.docs.guestbook.service.GuestBookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author User
 * @see com.liferay.docs.guestbook.service.base.GuestBookLocalServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil
 */
public class GuestBookLocalServiceImpl extends GuestBookLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil} to access the
	 * guest book local service.
	 */

	public List<GuestBook> getGuestbooks(long groupId, int status) throws SystemException {
		return guestBookPersistence.findByG_S(groupId, status);
	}

	public List<GuestBook> getGuestbooks(long groupId, int start, int end) throws SystemException {
		return guestBookPersistence.findByGroupId(groupId, start, end);
	}
	
	public int getGuestbooksCount(long groupId) throws SystemException {
		return guestBookPersistence.countByGroupId(groupId);
	}

	public GuestBook addGuestBook(long userId, String name, ServiceContext serviceContext)
			throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		long guestbookId = counterLocalService.increment();

		GuestBook guestbook = guestBookPersistence.create(guestbookId);

		guestbook.setUuid(serviceContext.getUuid());
		guestbook.setUserId(userId);
		guestbook.setGroupId(groupId);
		guestbook.setCompanyId(user.getCompanyId());
		guestbook.setUserName(user.getFullName());
		guestbook.setCreateDate(serviceContext.getCreateDate(now));
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setStatus(!isGroupOwner(groupId) ? WorkflowConstants.STATUS_DRAFT : WorkflowConstants.STATUS_APPROVED);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestBookPersistence.update(guestbook);

		resourceLocalService.addResources(serviceContext.getCompanyId(), groupId, userId, GuestBook.class.getName(),
				guestbookId, false, true, true);
		updateAssetGuestBook(serviceContext, guestbook, false);
		updateIndexer(guestbook, false);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(guestbook.getCompanyId(), guestbook.getGroupId(), guestbook.getUserId(),
				getModelClassName(), guestbook.getPrimaryKey(), guestbook, serviceContext);
		return guestbook;
	}

	public GuestBook updateGuestBook(long userId, long guestBookId, String name, ServiceContext serviceContext)
			throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);

		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		validate(name);

		GuestBook guestBook = getGuestBook(guestBookId);

		guestBook.setUserId(userId);
		guestBook.setUserName(user.getFullName());
		guestBook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestBook.setName(name);
		guestBook.setExpandoBridgeAttributes(serviceContext);

		guestBookPersistence.update(guestBook);

		resourceLocalService.updateResources(serviceContext.getCompanyId(), groupId, GuestBook.class.getName(),
				guestBookId, serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		updateAssetGuestBook(serviceContext, guestBook, false);
		updateIndexer(guestBook, false);
		return guestBook;

	}

	public GuestBook deleteGuestBook(long guestBookId, ServiceContext serviceContext)
			throws PortalException, SystemException {

		GuestBook guestBook = getGuestBook(guestBookId);

		List<Entry> entries = EntryLocalServiceUtil.getEntries(serviceContext.getScopeGroupId(), guestBookId);

		if (entries.size() > 0) {
			for (Entry entry : entries) {
				EntryLocalServiceUtil.deleteEntry(entry);
			}
		}

		resourceLocalService.deleteResource(serviceContext.getCompanyId(), GuestBook.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, guestBookId);

		updateAssetGuestBook(serviceContext, guestBook, true);

		updateIndexer(guestBook, true);

		guestBook = deleteGuestBook(guestBook);

		return guestBook;

	}

	public GuestBook updateStatus(long userId, long guestBookId, int status, 
			ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userLocalService.getUser(userId);
		GuestBook guestBook = getGuestBook(guestBookId);
		
		guestBook.setStatus(status);
		guestBook.setStatusByUserId(userId);
		guestBook.setStatusByUserName(user.getFullName());
		guestBook.setStatusDate(new Date());
		
		guestBookPersistence.update(guestBook);
		
		if (WorkflowConstants.STATUS_APPROVED == status) {
			assetEntryLocalService.updateVisible(getModelClassName(), guestBookId, true);
		} else {
			assetEntryLocalService.updateVisible(getModelClassName(), guestBookId, false);
		}
		
		return guestBook;
	}
	
	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new GuestBookNameException();
		}
	}

	private void updateIndexer(GuestBook guestBook, boolean isDelete) throws SearchException {
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(GuestBook.class.getName());
		if (isDelete) {
			indexer.delete(guestBook);
		} else {
			indexer.reindex(guestBook);
		}

	}

	private void updateAssetGuestBook(ServiceContext serviceContext, GuestBook guestBook, boolean isDelete)
			throws PortalException, SystemException {
		if (isDelete) {
			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(GuestBook.class.getName(),
					guestBook.getGuestBookId());
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			assetEntryLocalService.deleteEntry(assetEntry);

		} else {
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(guestBook.getUserId(), guestBook.getGroupId(),
					guestBook.getCreateDate(), guestBook.getModifiedDate(), GuestBook.class.getName(),
					guestBook.getGuestBookId(), guestBook.getUuid(), 0, serviceContext.getAssetCategoryIds(),
					serviceContext.getAssetTagNames(), true, null, null, null, ContentTypes.TEXT_HTML,
					guestBook.getName(), null, null, null, null, 0, 0, null, false);

			assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
					serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

		}
	}
	
	private boolean isGroupOwner(long groupId) {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return permissionChecker.isGroupOwner(groupId);
	}
}
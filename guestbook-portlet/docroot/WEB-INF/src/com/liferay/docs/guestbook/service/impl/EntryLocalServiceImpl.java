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

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.base.EntryLocalServiceBaseImpl;
import com.liferay.docs.guestbook.util.PortletKeys;
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
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.docs.guestbook.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author User
 * @see com.liferay.docs.guestbook.service.base.EntryLocalServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.docs.guestbook.service.EntryLocalServiceUtil} to access the entry
	 * local service.
	 */

	public List<Entry> getEntries(long groupId, long guestBookId) throws SystemException {
		return entryPersistence.findByG_G(groupId, guestBookId);
	}

	public List<Entry> getEntries(long groupId, long guestBookId, int status, int start, int end) throws SystemException {
		return entryPersistence.findByG_G_S(groupId, guestBookId, status, start, end);
	}
	
	public int getEntriesCount(long groupId, long guestBookId, int status) throws SystemException{
		return entryPersistence.countByG_G_S(groupId, guestBookId, status);
	}

	public boolean validate(String name, String email, String message) throws SystemException, PortalException {
		if (!Validator.isName(name)) {
			return false;
		}
		if (!Validator.isEmailAddress(email)) {
			return false;
		}
		if (Validator.isNull(message)) {
			return false;
		}
		return true;
	}

	public Entry addEntry(long userId, long guestBookId, String name, String email, String message,
			ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name, email, message);

		long entryId = counterLocalService.increment();

		Entry entry = entryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setCompanyId(user.getCompanyId());
		entry.setGroupId(groupId);
		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setStatus(!isGroupOwner(groupId) ? WorkflowConstants.STATUS_DRAFT : WorkflowConstants.STATUS_APPROVED);
		entry.setGuestBookId(guestBookId);
		entry.setExpandoBridgeAttributes(serviceContext);

		entryPersistence.update(entry);

		resourceLocalService.addResources(serviceContext.getCompanyId(), 
				groupId, userId, Entry.class.getName(),
				entryId, false, true, true);
		updateAssetEntry(serviceContext, entry, false);
		updateIndexer(entry, false);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(entry.getCompanyId(), 
		         entry.getGroupId(), entry.getUserId(), Entry.class.getName(), 
		         entry.getPrimaryKey(), entry, serviceContext);
		return entry;
	}

	public Entry deleteEntry(long entryId, ServiceContext serviceContext) throws PortalException, SystemException {
		Entry entry = getEntry(entryId);
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), Entry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, entryId);
		updateAssetEntry(serviceContext, entry, true);
		updateIndexer(entry, true);
		entry = deleteEntry(entry);
		
		return entry;

	}

	public Entry updateEntry(long userId, long guestBookId, long entryId, String name, String email, String message,
			ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);

		long groupId = serviceContext.getScopeGroupId();

		Date now = new Date();

		validate(name, email, message);

		Entry entry = getEntry(entryId);

		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setExpandoBridgeAttributes(serviceContext);

		entryPersistence.update(entry);

		resourceLocalService.updateResources(serviceContext.getCompanyId(), groupId, GuestBook.class.getName(), entryId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());
		updateAssetEntry(serviceContext, entry, false);
		updateIndexer(entry, false);
		
		return entry;

	}

	public Entry updateStatus(long userId, long entryId, int status,
			ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userLocalService.getUser(userId);
		Entry entry = getEntry(entryId);   
		
		entry.setStatus(status);
		entry.setStatusByUserId(userId);
		entry.setStatusByUserName(user.getFullName());
		entry.setStatusDate(new Date()); 
		
		entryPersistence.update(entry);
		
		if (WorkflowConstants.STATUS_APPROVED == status) {
			assetEntryLocalService.updateVisible(getModelClassName(), entryId, true);
		} else {
			assetEntryLocalService.updateVisible(getModelClassName(), entryId, false);
		}
		
		return entry;
	}
	
	private void updateIndexer(Entry entry, boolean isDelete) throws SearchException {
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class.getName());
		if (isDelete) {
			indexer.delete(entry);
		} else {
			indexer.reindex(entry);
		}

	}

	private void updateAssetEntry(ServiceContext serviceContext, Entry entry, boolean isDelete)
			throws SystemException, PortalException {
		if (isDelete) {
			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Entry.class.getName(), entry.getEntryId());
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			assetEntryLocalService.deleteEntry(assetEntry);
		} else {
			AssetEntry assetEntry = assetEntryLocalService.updateEntry(entry.getUserId(), 
					entry.getGroupId(), entry.getCreateDate(), 
					entry.getModifiedDate(), Entry.class.getName(), entry.getEntryId(), entry.getUuid(), 0,
					serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, null, null, null,
					ContentTypes.TEXT_HTML, entry.getMessage(), null, null, null, null, 0, 0, null, false);

			assetLinkLocalService.updateLinks(entry.getUserId(), assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
					AssetLinkConstants.TYPE_RELATED);
		}
	}
	
	public boolean isGroupOwner(long groupId) {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return permissionChecker.isGroupOwner(groupId);
	}

}
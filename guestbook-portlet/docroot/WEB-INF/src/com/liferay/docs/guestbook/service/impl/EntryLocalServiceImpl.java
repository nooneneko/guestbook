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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

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

	public List<Entry> getEntrys(long groupId, long guestBookId) throws SystemException {
		return entryPersistence.findByG_G(groupId, guestBookId);
	}

	public List<Entry> getEntrys(long groupId, long guestBookId, int start, int end) throws SystemException {
		return entryPersistence.findByG_G(groupId, guestBookId, start, end);
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
		entry.setGuestBookId(guestBookId);
		entry.setExpandoBridgeAttributes(serviceContext);

		entryPersistence.update(entry);

		resourceLocalService.addResources(serviceContext.getCompanyId(), groupId, userId, Entry.class.getName(),
				entryId, false, true, true);

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class);
		indexer.reindex(entry);
		return entry;
	}

	public Entry deleteEntry(long entryId, ServiceContext serviceContext) throws PortalException, SystemException {
		Entry entry = getEntry(entryId);
		resourceLocalService.deleteResource(serviceContext.getCompanyId(), Entry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, entryId);
		entry = deleteEntry(entry);
		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class);
		indexer.delete(entry);
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

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class);
		indexer.reindex(entry);
		return entry;

	}

}
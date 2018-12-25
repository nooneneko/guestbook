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
import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.base.GuestBookLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the guest book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.docs.guestbook.service.GuestBookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
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
	 * Never reference this interface directly. Always use {@link com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil} to access the guest book local service.
	 */

	
	public List<GuestBook> getGuestbooks (long groupId) throws SystemException {
	    return guestBookPersistence.findByGroupId(groupId);
	}

	public List<GuestBook> getGuestbooks (long groupId, int start, int end)
	   throws SystemException {
	    return guestBookPersistence.findByGroupId(groupId, start, end);
	}
	
	public GuestBook addGuestBook(long userId, 
			String name, ServiceContext serviceContext) throws SystemException, PortalException {
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
		guestbook.setExpandoBridgeAttributes(serviceContext);

		guestBookPersistence.update(guestbook);

		return guestbook;
	}
	
	protected void validate (String name) throws PortalException {
	    if (Validator.isNull(name)) {
	       throw new GuestBookNameException();
	    }
	}
}
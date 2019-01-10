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

import java.util.List;

import com.liferay.docs.guestbook.model.GuestBook;
import com.liferay.docs.guestbook.service.GuestBookLocalServiceUtil;
import com.liferay.docs.guestbook.service.base.GuestBookServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the guest book remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.docs.guestbook.service.GuestBookService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author User
 * @see com.liferay.docs.guestbook.service.base.GuestBookServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.GuestBookServiceUtil
 */
public class GuestBookServiceImpl extends GuestBookServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.docs.guestbook.service.GuestBookServiceUtil} to access the guest book remote service.
	 */
	
	public List<GuestBook> getGuestbooks(long groupId, int status) throws SystemException {
		return GuestBookLocalServiceUtil.getGuestbooks(groupId, status);
	}
	
	public List<GuestBook> getGuestbooks(long groupId, int start, int end) throws SystemException {
		return GuestBookLocalServiceUtil.getGuestbooks(groupId, start, end);
	}
	
	public int getGuestbooksCount(long groupId) throws SystemException {
		return GuestBookLocalServiceUtil.getGuestbooksCount(groupId);
	}
	
	public GuestBook addGuestBook(long userId, String name, ServiceContext serviceContext)
			throws SystemException, PortalException {
		return GuestBookLocalServiceUtil.addGuestBook(userId, name, serviceContext);
	}
	
	public GuestBook updateGuestBook(long userId, long guestBookId, String name, ServiceContext serviceContext)
			throws PortalException, SystemException {
		return GuestBookLocalServiceUtil.updateGuestBook(userId, guestBookId, name, serviceContext);
	}
	
	public GuestBook deleteGuestBook(long guestBookId, ServiceContext serviceContext)
			throws PortalException, SystemException {
		return GuestBookLocalServiceUtil.deleteGuestBook(guestBookId, serviceContext);
	}
	
}
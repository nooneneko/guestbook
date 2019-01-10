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

package com.liferay.docs.guestbook.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GuestBookService}.
 *
 * @author User
 * @see GuestBookService
 * @generated
 */
public class GuestBookServiceWrapper implements GuestBookService,
	ServiceWrapper<GuestBookService> {
	public GuestBookServiceWrapper(GuestBookService guestBookService) {
		_guestBookService = guestBookService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _guestBookService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_guestBookService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _guestBookService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookService.getGuestbooks(groupId, status);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookService.getGuestbooks(groupId, start, end);
	}

	@Override
	public int getGuestbooksCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookService.getGuestbooksCount(groupId);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook addGuestBook(
		long userId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookService.addGuestBook(userId, name, serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook updateGuestBook(
		long userId, long guestBookId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookService.updateGuestBook(userId, guestBookId, name,
			serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		long guestBookId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookService.deleteGuestBook(guestBookId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GuestBookService getWrappedGuestBookService() {
		return _guestBookService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGuestBookService(GuestBookService guestBookService) {
		_guestBookService = guestBookService;
	}

	@Override
	public GuestBookService getWrappedService() {
		return _guestBookService;
	}

	@Override
	public void setWrappedService(GuestBookService guestBookService) {
		_guestBookService = guestBookService;
	}

	private GuestBookService _guestBookService;
}
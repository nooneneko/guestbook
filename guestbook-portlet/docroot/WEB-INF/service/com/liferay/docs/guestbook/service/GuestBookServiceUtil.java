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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for GuestBook. This utility wraps
 * {@link com.liferay.docs.guestbook.service.impl.GuestBookServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author User
 * @see GuestBookService
 * @see com.liferay.docs.guestbook.service.base.GuestBookServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.impl.GuestBookServiceImpl
 * @generated
 */
public class GuestBookServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.docs.guestbook.service.impl.GuestBookServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestbooks(groupId, status);
	}

	public static java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestbooks(groupId, start, end);
	}

	public static int getGuestbooksCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestbooksCount(groupId);
	}

	public static com.liferay.docs.guestbook.model.GuestBook addGuestBook(
		long userId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addGuestBook(userId, name, serviceContext);
	}

	public static com.liferay.docs.guestbook.model.GuestBook updateGuestBook(
		long userId, long guestBookId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateGuestBook(userId, guestBookId, name, serviceContext);
	}

	public static com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		long guestBookId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGuestBook(guestBookId, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static GuestBookService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GuestBookService.class.getName());

			if (invokableService instanceof GuestBookService) {
				_service = (GuestBookService)invokableService;
			}
			else {
				_service = new GuestBookServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(GuestBookServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GuestBookService service) {
	}

	private static GuestBookService _service;
}
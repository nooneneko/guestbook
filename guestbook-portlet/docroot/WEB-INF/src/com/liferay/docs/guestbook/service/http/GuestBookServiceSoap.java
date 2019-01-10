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

package com.liferay.docs.guestbook.service.http;

import com.liferay.docs.guestbook.service.GuestBookServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.docs.guestbook.service.GuestBookServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.docs.guestbook.model.GuestBookSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.docs.guestbook.model.GuestBook}, that is translated to a
 * {@link com.liferay.docs.guestbook.model.GuestBookSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author User
 * @see GuestBookServiceHttp
 * @see com.liferay.docs.guestbook.model.GuestBookSoap
 * @see com.liferay.docs.guestbook.service.GuestBookServiceUtil
 * @generated
 */
public class GuestBookServiceSoap {
	public static com.liferay.docs.guestbook.model.GuestBookSoap[] getGuestbooks(
		long groupId, int status) throws RemoteException {
		try {
			java.util.List<com.liferay.docs.guestbook.model.GuestBook> returnValue =
				GuestBookServiceUtil.getGuestbooks(groupId, status);

			return com.liferay.docs.guestbook.model.GuestBookSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestBookSoap[] getGuestbooks(
		long groupId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.docs.guestbook.model.GuestBook> returnValue =
				GuestBookServiceUtil.getGuestbooks(groupId, start, end);

			return com.liferay.docs.guestbook.model.GuestBookSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static int getGuestbooksCount(long groupId)
		throws RemoteException {
		try {
			int returnValue = GuestBookServiceUtil.getGuestbooksCount(groupId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestBookSoap addGuestBook(
		long userId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.docs.guestbook.model.GuestBook returnValue = GuestBookServiceUtil.addGuestBook(userId,
					name, serviceContext);

			return com.liferay.docs.guestbook.model.GuestBookSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestBookSoap updateGuestBook(
		long userId, long guestBookId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.docs.guestbook.model.GuestBook returnValue = GuestBookServiceUtil.updateGuestBook(userId,
					guestBookId, name, serviceContext);

			return com.liferay.docs.guestbook.model.GuestBookSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.docs.guestbook.model.GuestBookSoap deleteGuestBook(
		long guestBookId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws RemoteException {
		try {
			com.liferay.docs.guestbook.model.GuestBook returnValue = GuestBookServiceUtil.deleteGuestBook(guestBookId,
					serviceContext);

			return com.liferay.docs.guestbook.model.GuestBookSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(GuestBookServiceSoap.class);
}
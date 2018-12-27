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
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GuestBook. This utility wraps
 * {@link com.liferay.docs.guestbook.service.impl.GuestBookLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author User
 * @see GuestBookLocalService
 * @see com.liferay.docs.guestbook.service.base.GuestBookLocalServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.impl.GuestBookLocalServiceImpl
 * @generated
 */
public class GuestBookLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.docs.guestbook.service.impl.GuestBookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the guest book to the database. Also notifies the appropriate model listeners.
	*
	* @param guestBook the guest book
	* @return the guest book that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook addGuestBook(
		com.liferay.docs.guestbook.model.GuestBook guestBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGuestBook(guestBook);
	}

	/**
	* Creates a new guest book with the primary key. Does not add the guest book to the database.
	*
	* @param guestBookId the primary key for the new guest book
	* @return the new guest book
	*/
	public static com.liferay.docs.guestbook.model.GuestBook createGuestBook(
		long guestBookId) {
		return getService().createGuestBook(guestBookId);
	}

	/**
	* Deletes the guest book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestBookId the primary key of the guest book
	* @return the guest book that was removed
	* @throws PortalException if a guest book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		long guestBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGuestBook(guestBookId);
	}

	/**
	* Deletes the guest book from the database. Also notifies the appropriate model listeners.
	*
	* @param guestBook the guest book
	* @return the guest book that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		com.liferay.docs.guestbook.model.GuestBook guestBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGuestBook(guestBook);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.guestbook.model.impl.GuestBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.guestbook.model.impl.GuestBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.docs.guestbook.model.GuestBook fetchGuestBook(
		long guestBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGuestBook(guestBookId);
	}

	/**
	* Returns the guest book with the matching UUID and company.
	*
	* @param uuid the guest book's UUID
	* @param companyId the primary key of the company
	* @return the matching guest book, or <code>null</code> if a matching guest book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook fetchGuestBookByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGuestBookByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the guest book matching the UUID and group.
	*
	* @param uuid the guest book's UUID
	* @param groupId the primary key of the group
	* @return the matching guest book, or <code>null</code> if a matching guest book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook fetchGuestBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGuestBookByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the guest book with the primary key.
	*
	* @param guestBookId the primary key of the guest book
	* @return the guest book
	* @throws PortalException if a guest book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook getGuestBook(
		long guestBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestBook(guestBookId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the guest book with the matching UUID and company.
	*
	* @param uuid the guest book's UUID
	* @param companyId the primary key of the company
	* @return the matching guest book
	* @throws PortalException if a matching guest book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook getGuestBookByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestBookByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the guest book matching the UUID and group.
	*
	* @param uuid the guest book's UUID
	* @param groupId the primary key of the group
	* @return the matching guest book
	* @throws PortalException if a matching guest book could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook getGuestBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestBookByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the guest books.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.docs.guestbook.model.impl.GuestBookModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of guest books
	* @param end the upper bound of the range of guest books (not inclusive)
	* @return the range of guest books
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestBooks(start, end);
	}

	/**
	* Returns the number of guest books.
	*
	* @return the number of guest books
	* @throws SystemException if a system exception occurred
	*/
	public static int getGuestBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestBooksCount();
	}

	/**
	* Updates the guest book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param guestBook the guest book
	* @return the guest book that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.docs.guestbook.model.GuestBook updateGuestBook(
		com.liferay.docs.guestbook.model.GuestBook guestBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGuestBook(guestBook);
	}

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
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestbooks(groupId);
	}

	public static java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestbooks(groupId, start, end);
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

	public static int getGuestbooksCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGuestbooksCount(groupId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GuestBookLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GuestBookLocalService.class.getName());

			if (invokableLocalService instanceof GuestBookLocalService) {
				_service = (GuestBookLocalService)invokableLocalService;
			}
			else {
				_service = new GuestBookLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GuestBookLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GuestBookLocalService service) {
	}

	private static GuestBookLocalService _service;
}
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
 * Provides a wrapper for {@link GuestBookLocalService}.
 *
 * @author User
 * @see GuestBookLocalService
 * @generated
 */
public class GuestBookLocalServiceWrapper implements GuestBookLocalService,
	ServiceWrapper<GuestBookLocalService> {
	public GuestBookLocalServiceWrapper(
		GuestBookLocalService guestBookLocalService) {
		_guestBookLocalService = guestBookLocalService;
	}

	/**
	* Adds the guest book to the database. Also notifies the appropriate model listeners.
	*
	* @param guestBook the guest book
	* @return the guest book that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook addGuestBook(
		com.liferay.docs.guestbook.model.GuestBook guestBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.addGuestBook(guestBook);
	}

	/**
	* Creates a new guest book with the primary key. Does not add the guest book to the database.
	*
	* @param guestBookId the primary key for the new guest book
	* @return the new guest book
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook createGuestBook(
		long guestBookId) {
		return _guestBookLocalService.createGuestBook(guestBookId);
	}

	/**
	* Deletes the guest book with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param guestBookId the primary key of the guest book
	* @return the guest book that was removed
	* @throws PortalException if a guest book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		long guestBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.deleteGuestBook(guestBookId);
	}

	/**
	* Deletes the guest book from the database. Also notifies the appropriate model listeners.
	*
	* @param guestBook the guest book
	* @return the guest book that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		com.liferay.docs.guestbook.model.GuestBook guestBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.deleteGuestBook(guestBook);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _guestBookLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook fetchGuestBook(
		long guestBookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.fetchGuestBook(guestBookId);
	}

	/**
	* Returns the guest book with the matching UUID and company.
	*
	* @param uuid the guest book's UUID
	* @param companyId the primary key of the company
	* @return the matching guest book, or <code>null</code> if a matching guest book could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook fetchGuestBookByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.fetchGuestBookByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the guest book matching the UUID and group.
	*
	* @param uuid the guest book's UUID
	* @param groupId the primary key of the group
	* @return the matching guest book, or <code>null</code> if a matching guest book could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook fetchGuestBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.fetchGuestBookByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns the guest book with the primary key.
	*
	* @param guestBookId the primary key of the guest book
	* @return the guest book
	* @throws PortalException if a guest book with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook getGuestBook(
		long guestBookId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestBook(guestBookId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.docs.guestbook.model.GuestBook getGuestBookByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestBookByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public com.liferay.docs.guestbook.model.GuestBook getGuestBookByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestBookByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestBooks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestBooks(start, end);
	}

	/**
	* Returns the number of guest books.
	*
	* @return the number of guest books
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGuestBooksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestBooksCount();
	}

	/**
	* Updates the guest book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param guestBook the guest book
	* @return the guest book that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.docs.guestbook.model.GuestBook updateGuestBook(
		com.liferay.docs.guestbook.model.GuestBook guestBook)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.updateGuestBook(guestBook);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _guestBookLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_guestBookLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _guestBookLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestbooks(groupId, status);
	}

	@Override
	public java.util.List<com.liferay.docs.guestbook.model.GuestBook> getGuestbooks(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestbooks(groupId, start, end);
	}

	@Override
	public int getGuestbooksCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.getGuestbooksCount(groupId);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook addGuestBook(
		long userId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.addGuestBook(userId, name, serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook updateGuestBook(
		long userId, long guestBookId, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.updateGuestBook(userId, guestBookId,
			name, serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook deleteGuestBook(
		long guestBookId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.deleteGuestBook(guestBookId,
			serviceContext);
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook updateStatus(
		long userId, long guestBookId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _guestBookLocalService.updateStatus(userId, guestBookId, status,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GuestBookLocalService getWrappedGuestBookLocalService() {
		return _guestBookLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGuestBookLocalService(
		GuestBookLocalService guestBookLocalService) {
		_guestBookLocalService = guestBookLocalService;
	}

	@Override
	public GuestBookLocalService getWrappedService() {
		return _guestBookLocalService;
	}

	@Override
	public void setWrappedService(GuestBookLocalService guestBookLocalService) {
		_guestBookLocalService = guestBookLocalService;
	}

	private GuestBookLocalService _guestBookLocalService;
}
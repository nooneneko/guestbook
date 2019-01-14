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

package com.imsw.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BorrowerLocalService}.
 *
 * @author User
 * @see BorrowerLocalService
 * @generated
 */
public class BorrowerLocalServiceWrapper implements BorrowerLocalService,
	ServiceWrapper<BorrowerLocalService> {
	public BorrowerLocalServiceWrapper(
		BorrowerLocalService borrowerLocalService) {
		_borrowerLocalService = borrowerLocalService;
	}

	/**
	* Adds the borrower to the database. Also notifies the appropriate model listeners.
	*
	* @param borrower the borrower
	* @return the borrower that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower addBorrower(com.imsw.model.Borrower borrower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.addBorrower(borrower);
	}

	/**
	* Creates a new borrower with the primary key. Does not add the borrower to the database.
	*
	* @param borrowerId the primary key for the new borrower
	* @return the new borrower
	*/
	@Override
	public com.imsw.model.Borrower createBorrower(long borrowerId) {
		return _borrowerLocalService.createBorrower(borrowerId);
	}

	/**
	* Deletes the borrower with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param borrowerId the primary key of the borrower
	* @return the borrower that was removed
	* @throws PortalException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower deleteBorrower(long borrowerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.deleteBorrower(borrowerId);
	}

	/**
	* Deletes the borrower from the database. Also notifies the appropriate model listeners.
	*
	* @param borrower the borrower
	* @return the borrower that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower deleteBorrower(
		com.imsw.model.Borrower borrower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.deleteBorrower(borrower);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _borrowerLocalService.dynamicQuery();
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
		return _borrowerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _borrowerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _borrowerLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _borrowerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _borrowerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.imsw.model.Borrower fetchBorrower(long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.fetchBorrower(borrowerId);
	}

	/**
	* Returns the borrower with the matching UUID and company.
	*
	* @param uuid the borrower's UUID
	* @param companyId the primary key of the company
	* @return the matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower fetchBorrowerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.fetchBorrowerByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the borrower matching the UUID and group.
	*
	* @param uuid the borrower's UUID
	* @param groupId the primary key of the group
	* @return the matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower fetchBorrowerByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.fetchBorrowerByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the borrower with the primary key.
	*
	* @param borrowerId the primary key of the borrower
	* @return the borrower
	* @throws PortalException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower getBorrower(long borrowerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getBorrower(borrowerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the borrower with the matching UUID and company.
	*
	* @param uuid the borrower's UUID
	* @param companyId the primary key of the company
	* @return the matching borrower
	* @throws PortalException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower getBorrowerByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getBorrowerByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns the borrower matching the UUID and group.
	*
	* @param uuid the borrower's UUID
	* @param groupId the primary key of the group
	* @return the matching borrower
	* @throws PortalException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower getBorrowerByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getBorrowerByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the borrowers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @return the range of borrowers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.imsw.model.Borrower> getBorrowers(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getBorrowers(start, end);
	}

	/**
	* Returns the number of borrowers.
	*
	* @return the number of borrowers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBorrowersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getBorrowersCount();
	}

	/**
	* Updates the borrower in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param borrower the borrower
	* @return the borrower that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Borrower updateBorrower(
		com.imsw.model.Borrower borrower)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.updateBorrower(borrower);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _borrowerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_borrowerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _borrowerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.imsw.model.Borrower> getListBorrowers(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getListBorrowers(groupId, start, end);
	}

	@Override
	public java.util.List<com.imsw.model.Borrower> getListBorrowers(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.getListBorrowers(groupId);
	}

	@Override
	public int countBorrowers(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.countBorrowers(groupId);
	}

	@Override
	public com.imsw.model.Borrower addBorrower(long userId,
		java.lang.String name, java.lang.String email,
		java.lang.String address, java.lang.String city,
		java.lang.String phoneNo,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _borrowerLocalService.addBorrower(userId, name, email, address,
			city, phoneNo, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BorrowerLocalService getWrappedBorrowerLocalService() {
		return _borrowerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBorrowerLocalService(
		BorrowerLocalService borrowerLocalService) {
		_borrowerLocalService = borrowerLocalService;
	}

	@Override
	public BorrowerLocalService getWrappedService() {
		return _borrowerLocalService;
	}

	@Override
	public void setWrappedService(BorrowerLocalService borrowerLocalService) {
		_borrowerLocalService = borrowerLocalService;
	}

	private BorrowerLocalService _borrowerLocalService;
}
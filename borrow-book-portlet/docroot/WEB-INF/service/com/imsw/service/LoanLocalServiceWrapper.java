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
 * Provides a wrapper for {@link LoanLocalService}.
 *
 * @author User
 * @see LoanLocalService
 * @generated
 */
public class LoanLocalServiceWrapper implements LoanLocalService,
	ServiceWrapper<LoanLocalService> {
	public LoanLocalServiceWrapper(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

	/**
	* Adds the loan to the database. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan addLoan(com.imsw.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.addLoan(loan);
	}

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	@Override
	public com.imsw.model.Loan createLoan(long loanId) {
		return _loanLocalService.createLoan(loanId);
	}

	/**
	* Deletes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws PortalException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan deleteLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.deleteLoan(loanId);
	}

	/**
	* Deletes the loan from the database. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan deleteLoan(com.imsw.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.deleteLoan(loan);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _loanLocalService.dynamicQuery();
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
		return _loanLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loanLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _loanLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _loanLocalService.dynamicQueryCount(dynamicQuery);
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
		return _loanLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.imsw.model.Loan fetchLoan(long loanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.fetchLoan(loanId);
	}

	/**
	* Returns the loan with the matching UUID and company.
	*
	* @param uuid the loan's UUID
	* @param companyId the primary key of the company
	* @return the matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan fetchLoanByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.fetchLoanByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the loan matching the UUID and group.
	*
	* @param uuid the loan's UUID
	* @param groupId the primary key of the group
	* @return the matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan fetchLoanByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.fetchLoanByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the loan with the primary key.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws PortalException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan getLoan(long loanId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoan(loanId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the loan with the matching UUID and company.
	*
	* @param uuid the loan's UUID
	* @param companyId the primary key of the company
	* @return the matching loan
	* @throws PortalException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan getLoanByUuidAndCompanyId(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoanByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns the loan matching the UUID and group.
	*
	* @param uuid the loan's UUID
	* @param groupId the primary key of the group
	* @return the matching loan
	* @throws PortalException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan getLoanByUuidAndGroupId(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoanByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of loans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.imsw.model.Loan> getLoans(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoans(start, end);
	}

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getLoansCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.getLoansCount();
	}

	/**
	* Updates the loan in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param loan the loan
	* @return the loan that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.imsw.model.Loan updateLoan(com.imsw.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loanLocalService.updateLoan(loan);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _loanLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_loanLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _loanLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public LoanLocalService getWrappedLoanLocalService() {
		return _loanLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedLoanLocalService(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

	@Override
	public LoanLocalService getWrappedService() {
		return _loanLocalService;
	}

	@Override
	public void setWrappedService(LoanLocalService loanLocalService) {
		_loanLocalService = loanLocalService;
	}

	private LoanLocalService _loanLocalService;
}
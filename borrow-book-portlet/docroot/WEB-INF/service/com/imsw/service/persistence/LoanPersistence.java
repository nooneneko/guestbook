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

package com.imsw.service.persistence;

import com.imsw.model.Loan;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author User
 * @see LoanPersistenceImpl
 * @see LoanUtil
 * @generated
 */
public interface LoanPersistence extends BasePersistence<Loan> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the loans where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where uuid = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan[] findByUuid_PrevAndNext(long loanId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan where uuid = &#63; and groupId = &#63; or throws a {@link com.imsw.NoSuchLoanException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByUUID_G(java.lang.String uuid, long groupId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the loan where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the loan that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan[] findByUuid_C_PrevAndNext(long loanId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_B_B(long groupId,
		long bookId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_B_B(long groupId,
		long bookId, long borrowerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_B_B(long groupId,
		long bookId, long borrowerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByG_B_B_First(long groupId, long bookId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByG_B_B_First(long groupId, long bookId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByG_B_B_Last(long groupId, long bookId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByG_B_B_Last(long groupId, long bookId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan[] findByG_B_B_PrevAndNext(long loanId,
		long groupId, long bookId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_B_B(long groupId, long bookId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_B_B(long groupId, long bookId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_Br(long groupId,
		long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where groupId = &#63; and borrowerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_Br(long groupId,
		long borrowerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where groupId = &#63; and borrowerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_Br(long groupId,
		long borrowerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByG_Br_First(long groupId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByG_Br_First(long groupId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByG_Br_Last(long groupId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByG_Br_Last(long groupId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan[] findByG_Br_PrevAndNext(long loanId,
		long groupId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where groupId = &#63; and borrowerId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_Br(long groupId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_Br(long groupId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_B(long groupId,
		long bookId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where groupId = &#63; and bookId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_B(long groupId,
		long bookId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where groupId = &#63; and bookId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByG_B(long groupId,
		long bookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByG_B_First(long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByG_B_First(long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByG_B_Last(long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByG_B_Last(long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan[] findByG_B_PrevAndNext(long loanId,
		long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where groupId = &#63; and bookId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_B(long groupId, long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_B(long groupId, long bookId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the loans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @return the range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByGroupId(long groupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loans before and after the current loan in the ordered set where groupId = &#63;.
	*
	* @param loanId the primary key of the current loan
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan[] findByGroupId_PrevAndNext(long loanId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the loan in the entity cache if it is enabled.
	*
	* @param loan the loan
	*/
	public void cacheResult(com.imsw.model.Loan loan);

	/**
	* Caches the loans in the entity cache if it is enabled.
	*
	* @param loans the loans
	*/
	public void cacheResult(java.util.List<com.imsw.model.Loan> loans);

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	public com.imsw.model.Loan create(long loanId);

	/**
	* Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan remove(long loanId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.imsw.model.Loan updateImpl(com.imsw.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan with the primary key or throws a {@link com.imsw.NoSuchLoanException} if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan findByPrimaryKey(long loanId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan, or <code>null</code> if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Loan fetchByPrimaryKey(long loanId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the loans.
	*
	* @return the loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.imsw.model.Loan> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the loans.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.LoanModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of loans
	* @param end the upper bound of the range of loans (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of loans
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Loan> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the loans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
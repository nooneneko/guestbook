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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the loan service. This utility wraps {@link LoanPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author User
 * @see LoanPersistence
 * @see LoanPersistenceImpl
 * @generated
 */
public class LoanUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Loan loan) {
		getPersistence().clearCache(loan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Loan> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Loan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Loan> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Loan update(Loan loan) throws SystemException {
		return getPersistence().update(loan);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Loan update(Loan loan, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(loan, serviceContext);
	}

	/**
	* Returns all the loans where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.imsw.model.Loan[] findByUuid_PrevAndNext(long loanId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(loanId, uuid, orderByComparator);
	}

	/**
	* Removes all the loans where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of loans where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the loan where uuid = &#63; and groupId = &#63; or throws a {@link com.imsw.NoSuchLoanException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the loan where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the loan that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of loans where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the loans where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static com.imsw.model.Loan findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static com.imsw.model.Loan findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static com.imsw.model.Loan[] findByUuid_C_PrevAndNext(long loanId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(loanId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the loans where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of loans where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findByG_B_B(
		long groupId, long bookId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_B_B(groupId, bookId, borrowerId);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByG_B_B(
		long groupId, long bookId, long borrowerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_B(groupId, bookId, borrowerId, start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByG_B_B(
		long groupId, long bookId, long borrowerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_B(groupId, bookId, borrowerId, start, end,
			orderByComparator);
	}

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
	public static com.imsw.model.Loan findByG_B_B_First(long groupId,
		long bookId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_B_First(groupId, bookId, borrowerId,
			orderByComparator);
	}

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
	public static com.imsw.model.Loan fetchByG_B_B_First(long groupId,
		long bookId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_B_B_First(groupId, bookId, borrowerId,
			orderByComparator);
	}

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
	public static com.imsw.model.Loan findByG_B_B_Last(long groupId,
		long bookId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_B_Last(groupId, bookId, borrowerId,
			orderByComparator);
	}

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
	public static com.imsw.model.Loan fetchByG_B_B_Last(long groupId,
		long bookId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_B_B_Last(groupId, bookId, borrowerId,
			orderByComparator);
	}

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
	public static com.imsw.model.Loan[] findByG_B_B_PrevAndNext(long loanId,
		long groupId, long bookId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_B_PrevAndNext(loanId, groupId, bookId,
			borrowerId, orderByComparator);
	}

	/**
	* Removes all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_B_B(long groupId, long bookId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_B_B(groupId, bookId, borrowerId);
	}

	/**
	* Returns the number of loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param borrowerId the borrower ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_B_B(long groupId, long bookId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_B_B(groupId, bookId, borrowerId);
	}

	/**
	* Returns all the loans where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findByG_Br(long groupId,
		long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_Br(groupId, borrowerId);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByG_Br(long groupId,
		long borrowerId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_Br(groupId, borrowerId, start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByG_Br(long groupId,
		long borrowerId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_Br(groupId, borrowerId, start, end,
			orderByComparator);
	}

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
	public static com.imsw.model.Loan findByG_Br_First(long groupId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_Br_First(groupId, borrowerId, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByG_Br_First(long groupId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_Br_First(groupId, borrowerId, orderByComparator);
	}

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
	public static com.imsw.model.Loan findByG_Br_Last(long groupId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_Br_Last(groupId, borrowerId, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByG_Br_Last(long groupId,
		long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_Br_Last(groupId, borrowerId, orderByComparator);
	}

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
	public static com.imsw.model.Loan[] findByG_Br_PrevAndNext(long loanId,
		long groupId, long borrowerId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_Br_PrevAndNext(loanId, groupId, borrowerId,
			orderByComparator);
	}

	/**
	* Removes all the loans where groupId = &#63; and borrowerId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_Br(long groupId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_Br(groupId, borrowerId);
	}

	/**
	* Returns the number of loans where groupId = &#63; and borrowerId = &#63;.
	*
	* @param groupId the group ID
	* @param borrowerId the borrower ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_Br(long groupId, long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_Br(groupId, borrowerId);
	}

	/**
	* Returns all the loans where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findByG_B(long groupId,
		long bookId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_B(groupId, bookId);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByG_B(long groupId,
		long bookId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_B(groupId, bookId, start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByG_B(long groupId,
		long bookId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B(groupId, bookId, start, end, orderByComparator);
	}

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
	public static com.imsw.model.Loan findByG_B_First(long groupId,
		long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_First(groupId, bookId, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByG_B_First(long groupId,
		long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_B_First(groupId, bookId, orderByComparator);
	}

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
	public static com.imsw.model.Loan findByG_B_Last(long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_Last(groupId, bookId, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByG_B_Last(long groupId,
		long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByG_B_Last(groupId, bookId, orderByComparator);
	}

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
	public static com.imsw.model.Loan[] findByG_B_PrevAndNext(long loanId,
		long groupId, long bookId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_B_PrevAndNext(loanId, groupId, bookId,
			orderByComparator);
	}

	/**
	* Removes all the loans where groupId = &#63; and bookId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_B(long groupId, long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_B(groupId, bookId);
	}

	/**
	* Returns the number of loans where groupId = &#63; and bookId = &#63;.
	*
	* @param groupId the group ID
	* @param bookId the book ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_B(long groupId, long bookId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_B(groupId, bookId);
	}

	/**
	* Returns all the loans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan
	* @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last loan in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching loan, or <code>null</code> if a matching loan could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

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
	public static com.imsw.model.Loan[] findByGroupId_PrevAndNext(long loanId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(loanId, groupId, orderByComparator);
	}

	/**
	* Removes all the loans where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of loans where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the loan in the entity cache if it is enabled.
	*
	* @param loan the loan
	*/
	public static void cacheResult(com.imsw.model.Loan loan) {
		getPersistence().cacheResult(loan);
	}

	/**
	* Caches the loans in the entity cache if it is enabled.
	*
	* @param loans the loans
	*/
	public static void cacheResult(java.util.List<com.imsw.model.Loan> loans) {
		getPersistence().cacheResult(loans);
	}

	/**
	* Creates a new loan with the primary key. Does not add the loan to the database.
	*
	* @param loanId the primary key for the new loan
	* @return the new loan
	*/
	public static com.imsw.model.Loan create(long loanId) {
		return getPersistence().create(loanId);
	}

	/**
	* Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param loanId the primary key of the loan
	* @return the loan that was removed
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan remove(long loanId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(loanId);
	}

	public static com.imsw.model.Loan updateImpl(com.imsw.model.Loan loan)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(loan);
	}

	/**
	* Returns the loan with the primary key or throws a {@link com.imsw.NoSuchLoanException} if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan
	* @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan findByPrimaryKey(long loanId)
		throws com.imsw.NoSuchLoanException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(loanId);
	}

	/**
	* Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param loanId the primary key of the loan
	* @return the loan, or <code>null</code> if a loan with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.imsw.model.Loan fetchByPrimaryKey(long loanId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(loanId);
	}

	/**
	* Returns all the loans.
	*
	* @return the loans
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.imsw.model.Loan> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.imsw.model.Loan> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.imsw.model.Loan> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the loans from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of loans.
	*
	* @return the number of loans
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LoanPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LoanPersistence)PortletBeanLocatorUtil.locate(com.imsw.service.ClpSerializer.getServletContextName(),
					LoanPersistence.class.getName());

			ReferenceRegistry.registerReference(LoanUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(LoanPersistence persistence) {
	}

	private static LoanPersistence _persistence;
}
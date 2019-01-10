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

import com.imsw.model.Borrower;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the borrower service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author User
 * @see BorrowerPersistenceImpl
 * @see BorrowerUtil
 * @generated
 */
public interface BorrowerPersistence extends BasePersistence<Borrower> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BorrowerUtil} to access the borrower persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the borrowers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the borrowers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @return the range of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the borrowers where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first borrower in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first borrower in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last borrower in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last borrower in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrowers before and after the current borrower in the ordered set where uuid = &#63;.
	*
	* @param borrowerId the primary key of the current borrower
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next borrower
	* @throws com.imsw.NoSuchBorrowerException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower[] findByUuid_PrevAndNext(long borrowerId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the borrowers where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of borrowers where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower where uuid = &#63; and groupId = &#63; or throws a {@link com.imsw.NoSuchBorrowerException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the borrower where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the borrower that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of borrowers where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the borrowers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the borrowers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @return the range of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the borrowers where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first borrower in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first borrower in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last borrower in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last borrower in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrowers before and after the current borrower in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param borrowerId the primary key of the current borrower
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next borrower
	* @throws com.imsw.NoSuchBorrowerException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower[] findByUuid_C_PrevAndNext(long borrowerId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the borrowers where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of borrowers where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the borrowers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the borrowers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @return the range of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByGroupId(long groupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the borrowers where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findByGroupId(long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first borrower in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first borrower in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last borrower in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching borrower
	* @throws com.imsw.NoSuchBorrowerException if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last borrower in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching borrower, or <code>null</code> if a matching borrower could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrowers before and after the current borrower in the ordered set where groupId = &#63;.
	*
	* @param borrowerId the primary key of the current borrower
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next borrower
	* @throws com.imsw.NoSuchBorrowerException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower[] findByGroupId_PrevAndNext(
		long borrowerId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the borrowers where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of borrowers where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching borrowers
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the borrower in the entity cache if it is enabled.
	*
	* @param borrower the borrower
	*/
	public void cacheResult(com.imsw.model.Borrower borrower);

	/**
	* Caches the borrowers in the entity cache if it is enabled.
	*
	* @param borrowers the borrowers
	*/
	public void cacheResult(java.util.List<com.imsw.model.Borrower> borrowers);

	/**
	* Creates a new borrower with the primary key. Does not add the borrower to the database.
	*
	* @param borrowerId the primary key for the new borrower
	* @return the new borrower
	*/
	public com.imsw.model.Borrower create(long borrowerId);

	/**
	* Removes the borrower with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param borrowerId the primary key of the borrower
	* @return the borrower that was removed
	* @throws com.imsw.NoSuchBorrowerException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower remove(long borrowerId)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.imsw.model.Borrower updateImpl(com.imsw.model.Borrower borrower)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower with the primary key or throws a {@link com.imsw.NoSuchBorrowerException} if it could not be found.
	*
	* @param borrowerId the primary key of the borrower
	* @return the borrower
	* @throws com.imsw.NoSuchBorrowerException if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower findByPrimaryKey(long borrowerId)
		throws com.imsw.NoSuchBorrowerException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the borrower with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param borrowerId the primary key of the borrower
	* @return the borrower, or <code>null</code> if a borrower with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.imsw.model.Borrower fetchByPrimaryKey(long borrowerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the borrowers.
	*
	* @return the borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.imsw.model.Borrower> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the borrowers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.imsw.model.impl.BorrowerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of borrowers
	* @param end the upper bound of the range of borrowers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of borrowers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.imsw.model.Borrower> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the borrowers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of borrowers.
	*
	* @return the number of borrowers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}
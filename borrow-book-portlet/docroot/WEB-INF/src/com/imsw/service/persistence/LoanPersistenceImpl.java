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

import com.imsw.NoSuchLoanException;

import com.imsw.model.Loan;
import com.imsw.model.impl.LoanImpl;
import com.imsw.model.impl.LoanModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the loan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author User
 * @see LoanPersistence
 * @see LoanUtil
 * @generated
 */
public class LoanPersistenceImpl extends BasePersistenceImpl<Loan>
	implements LoanPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LoanUtil} to access the loan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LoanImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LoanModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the loans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Loan> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Loan> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if (!Validator.equals(uuid, loan.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Loan findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByUuid_First(uuid, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan findByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByUuid_Last(uuid, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan[] findByUuid_PrevAndNext(long loanId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByUuid_PrevAndNext(session, loan, uuid,
					orderByComparator, true);

			array[1] = loan;

			array[2] = getByUuid_PrevAndNext(session, loan, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByUuid_PrevAndNext(Session session, Loan loan,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (Loan loan : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOAN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "loan.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "loan.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(loan.uuid IS NULL OR loan.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			LoanModelImpl.UUID_COLUMN_BITMASK |
			LoanModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the loan where uuid = &#63; and groupId = &#63; or throws a {@link com.imsw.NoSuchLoanException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loan
	 * @throws com.imsw.NoSuchLoanException if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByUUID_G(String uuid, long groupId)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByUUID_G(uuid, groupId);

		if (loan == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLoanException(msg.toString());
		}

		return loan;
	}

	/**
	 * Returns the loan where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByUUID_G(String uuid, long groupId)
		throws SystemException {
		return fetchByUUID_G(uuid, groupId, true);
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
	@Override
	public Loan fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Loan) {
			Loan loan = (Loan)result;

			if (!Validator.equals(uuid, loan.getUuid()) ||
					(groupId != loan.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LOAN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Loan> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Loan loan = list.get(0);

					result = loan;

					cacheResult(loan);

					if ((loan.getUuid() == null) ||
							!loan.getUuid().equals(uuid) ||
							(loan.getGroupId() != groupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, loan);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Loan)result;
		}
	}

	/**
	 * Removes the loan where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the loan that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan removeByUUID_G(String uuid, long groupId)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByUUID_G(uuid, groupId);

		return remove(loan);
	}

	/**
	 * Returns the number of loans where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "loan.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "loan.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(loan.uuid IS NULL OR loan.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "loan.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			LoanModelImpl.UUID_COLUMN_BITMASK |
			LoanModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByUuid_C(String uuid, long companyId)
		throws SystemException {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Loan> findByUuid_C(String uuid, long companyId, int start,
		int end) throws SystemException {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Loan> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if (!Validator.equals(uuid, loan.getUuid()) ||
						(companyId != loan.getCompanyId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Loan findByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan[] findByUuid_C_PrevAndNext(long loanId, String uuid,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, loan, uuid, companyId,
					orderByComparator, true);

			array[1] = loan;

			array[2] = getByUuid_C_PrevAndNext(session, loan, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByUuid_C_PrevAndNext(Session session, Loan loan,
		String uuid, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId)
		throws SystemException {
		for (Loan loan : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "loan.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "loan.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(loan.uuid IS NULL OR loan.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "loan.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_B_B = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_B_B",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B_B = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_B_B",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			LoanModelImpl.GROUPID_COLUMN_BITMASK |
			LoanModelImpl.BOOKID_COLUMN_BITMASK |
			LoanModelImpl.BORROWERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_B_B = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_B_B",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param bookId the book ID
	 * @param borrowerId the borrower ID
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByG_B_B(long groupId, long bookId, long borrowerId)
		throws SystemException {
		return findByG_B_B(groupId, bookId, borrowerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Loan> findByG_B_B(long groupId, long bookId, long borrowerId,
		int start, int end) throws SystemException {
		return findByG_B_B(groupId, bookId, borrowerId, start, end, null);
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
	@Override
	public List<Loan> findByG_B_B(long groupId, long bookId, long borrowerId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B_B;
			finderArgs = new Object[] { groupId, bookId, borrowerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_B_B;
			finderArgs = new Object[] {
					groupId, bookId, borrowerId,
					
					start, end, orderByComparator
				};
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if ((groupId != loan.getGroupId()) ||
						(bookId != loan.getBookId()) ||
						(borrowerId != loan.getBorrowerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_G_B_B_GROUPID_2);

			query.append(_FINDER_COLUMN_G_B_B_BOOKID_2);

			query.append(_FINDER_COLUMN_G_B_B_BORROWERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(bookId);

				qPos.add(borrowerId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Loan findByG_B_B_First(long groupId, long bookId, long borrowerId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByG_B_B_First(groupId, bookId, borrowerId,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", bookId=");
		msg.append(bookId);

		msg.append(", borrowerId=");
		msg.append(borrowerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByG_B_B_First(long groupId, long bookId, long borrowerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByG_B_B(groupId, bookId, borrowerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan findByG_B_B_Last(long groupId, long bookId, long borrowerId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByG_B_B_Last(groupId, bookId, borrowerId,
				orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", bookId=");
		msg.append(bookId);

		msg.append(", borrowerId=");
		msg.append(borrowerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByG_B_B_Last(long groupId, long bookId, long borrowerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_B_B(groupId, bookId, borrowerId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByG_B_B(groupId, bookId, borrowerId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan[] findByG_B_B_PrevAndNext(long loanId, long groupId,
		long bookId, long borrowerId, OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByG_B_B_PrevAndNext(session, loan, groupId, bookId,
					borrowerId, orderByComparator, true);

			array[1] = loan;

			array[2] = getByG_B_B_PrevAndNext(session, loan, groupId, bookId,
					borrowerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByG_B_B_PrevAndNext(Session session, Loan loan,
		long groupId, long bookId, long borrowerId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		query.append(_FINDER_COLUMN_G_B_B_GROUPID_2);

		query.append(_FINDER_COLUMN_G_B_B_BOOKID_2);

		query.append(_FINDER_COLUMN_G_B_B_BORROWERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(bookId);

		qPos.add(borrowerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where groupId = &#63; and bookId = &#63; and borrowerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param bookId the book ID
	 * @param borrowerId the borrower ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_B_B(long groupId, long bookId, long borrowerId)
		throws SystemException {
		for (Loan loan : findByG_B_B(groupId, bookId, borrowerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
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
	@Override
	public int countByG_B_B(long groupId, long bookId, long borrowerId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_B_B;

		Object[] finderArgs = new Object[] { groupId, bookId, borrowerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_G_B_B_GROUPID_2);

			query.append(_FINDER_COLUMN_G_B_B_BOOKID_2);

			query.append(_FINDER_COLUMN_G_B_B_BORROWERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(bookId);

				qPos.add(borrowerId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_B_B_GROUPID_2 = "loan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_B_B_BOOKID_2 = "loan.bookId = ? AND ";
	private static final String _FINDER_COLUMN_G_B_B_BORROWERID_2 = "loan.borrowerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_BR = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_Br",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_BR = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_Br",
			new String[] { Long.class.getName(), Long.class.getName() },
			LoanModelImpl.GROUPID_COLUMN_BITMASK |
			LoanModelImpl.BORROWERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_BR = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_Br",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loans where groupId = &#63; and borrowerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param borrowerId the borrower ID
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByG_Br(long groupId, long borrowerId)
		throws SystemException {
		return findByG_Br(groupId, borrowerId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Loan> findByG_Br(long groupId, long borrowerId, int start,
		int end) throws SystemException {
		return findByG_Br(groupId, borrowerId, start, end, null);
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
	@Override
	public List<Loan> findByG_Br(long groupId, long borrowerId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_BR;
			finderArgs = new Object[] { groupId, borrowerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_BR;
			finderArgs = new Object[] {
					groupId, borrowerId,
					
					start, end, orderByComparator
				};
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if ((groupId != loan.getGroupId()) ||
						(borrowerId != loan.getBorrowerId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_G_BR_GROUPID_2);

			query.append(_FINDER_COLUMN_G_BR_BORROWERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(borrowerId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Loan findByG_Br_First(long groupId, long borrowerId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByG_Br_First(groupId, borrowerId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", borrowerId=");
		msg.append(borrowerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByG_Br_First(long groupId, long borrowerId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByG_Br(groupId, borrowerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan findByG_Br_Last(long groupId, long borrowerId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByG_Br_Last(groupId, borrowerId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", borrowerId=");
		msg.append(borrowerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByG_Br_Last(long groupId, long borrowerId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_Br(groupId, borrowerId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByG_Br(groupId, borrowerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan[] findByG_Br_PrevAndNext(long loanId, long groupId,
		long borrowerId, OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByG_Br_PrevAndNext(session, loan, groupId,
					borrowerId, orderByComparator, true);

			array[1] = loan;

			array[2] = getByG_Br_PrevAndNext(session, loan, groupId,
					borrowerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByG_Br_PrevAndNext(Session session, Loan loan,
		long groupId, long borrowerId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		query.append(_FINDER_COLUMN_G_BR_GROUPID_2);

		query.append(_FINDER_COLUMN_G_BR_BORROWERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(borrowerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where groupId = &#63; and borrowerId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param borrowerId the borrower ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_Br(long groupId, long borrowerId)
		throws SystemException {
		for (Loan loan : findByG_Br(groupId, borrowerId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where groupId = &#63; and borrowerId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param borrowerId the borrower ID
	 * @return the number of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_Br(long groupId, long borrowerId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_BR;

		Object[] finderArgs = new Object[] { groupId, borrowerId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_G_BR_GROUPID_2);

			query.append(_FINDER_COLUMN_G_BR_BORROWERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(borrowerId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_BR_GROUPID_2 = "loan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_BR_BORROWERID_2 = "loan.borrowerId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_B = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_B",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_B",
			new String[] { Long.class.getName(), Long.class.getName() },
			LoanModelImpl.GROUPID_COLUMN_BITMASK |
			LoanModelImpl.BOOKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_B = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_B",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the loans where groupId = &#63; and bookId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param bookId the book ID
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByG_B(long groupId, long bookId)
		throws SystemException {
		return findByG_B(groupId, bookId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Loan> findByG_B(long groupId, long bookId, int start, int end)
		throws SystemException {
		return findByG_B(groupId, bookId, start, end, null);
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
	@Override
	public List<Loan> findByG_B(long groupId, long bookId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B;
			finderArgs = new Object[] { groupId, bookId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_B;
			finderArgs = new Object[] {
					groupId, bookId,
					
					start, end, orderByComparator
				};
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if ((groupId != loan.getGroupId()) ||
						(bookId != loan.getBookId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_G_B_GROUPID_2);

			query.append(_FINDER_COLUMN_G_B_BOOKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(bookId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Loan findByG_B_First(long groupId, long bookId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByG_B_First(groupId, bookId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", bookId=");
		msg.append(bookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByG_B_First(long groupId, long bookId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByG_B(groupId, bookId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan findByG_B_Last(long groupId, long bookId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByG_B_Last(groupId, bookId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", bookId=");
		msg.append(bookId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
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
	@Override
	public Loan fetchByG_B_Last(long groupId, long bookId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByG_B(groupId, bookId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByG_B(groupId, bookId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan[] findByG_B_PrevAndNext(long loanId, long groupId, long bookId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByG_B_PrevAndNext(session, loan, groupId, bookId,
					orderByComparator, true);

			array[1] = loan;

			array[2] = getByG_B_PrevAndNext(session, loan, groupId, bookId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByG_B_PrevAndNext(Session session, Loan loan,
		long groupId, long bookId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		query.append(_FINDER_COLUMN_G_B_GROUPID_2);

		query.append(_FINDER_COLUMN_G_B_BOOKID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(bookId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where groupId = &#63; and bookId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param bookId the book ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_B(long groupId, long bookId)
		throws SystemException {
		for (Loan loan : findByG_B(groupId, bookId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where groupId = &#63; and bookId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param bookId the book ID
	 * @return the number of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_B(long groupId, long bookId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_B;

		Object[] finderArgs = new Object[] { groupId, bookId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_G_B_GROUPID_2);

			query.append(_FINDER_COLUMN_G_B_BOOKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(bookId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_B_GROUPID_2 = "loan.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_B_BOOKID_2 = "loan.bookId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, LoanImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			LoanModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the loans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Loan> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Loan> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Loan loan : list) {
				if ((groupId != loan.getGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LoanModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Loan findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByGroupId_First(groupId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the first loan in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Loan> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByGroupId_Last(groupId, orderByComparator);

		if (loan != null) {
			return loan;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLoanException(msg.toString());
	}

	/**
	 * Returns the last loan in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loan, or <code>null</code> if a matching loan could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Loan> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Loan[] findByGroupId_PrevAndNext(long loanId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchLoanException, SystemException {
		Loan loan = findByPrimaryKey(loanId);

		Session session = null;

		try {
			session = openSession();

			Loan[] array = new LoanImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, loan, groupId,
					orderByComparator, true);

			array[1] = loan;

			array[2] = getByGroupId_PrevAndNext(session, loan, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Loan getByGroupId_PrevAndNext(Session session, Loan loan,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LOAN_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LoanModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(loan);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Loan> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the loans where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Loan loan : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LOAN_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "loan.groupId = ?";

	public LoanPersistenceImpl() {
		setModelClass(Loan.class);
	}

	/**
	 * Caches the loan in the entity cache if it is enabled.
	 *
	 * @param loan the loan
	 */
	@Override
	public void cacheResult(Loan loan) {
		EntityCacheUtil.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey(), loan);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { loan.getUuid(), loan.getGroupId() }, loan);

		loan.resetOriginalValues();
	}

	/**
	 * Caches the loans in the entity cache if it is enabled.
	 *
	 * @param loans the loans
	 */
	@Override
	public void cacheResult(List<Loan> loans) {
		for (Loan loan : loans) {
			if (EntityCacheUtil.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
						LoanImpl.class, loan.getPrimaryKey()) == null) {
				cacheResult(loan);
			}
			else {
				loan.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all loans.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LoanImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LoanImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the loan.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Loan loan) {
		EntityCacheUtil.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(loan);
	}

	@Override
	public void clearCache(List<Loan> loans) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Loan loan : loans) {
			EntityCacheUtil.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
				LoanImpl.class, loan.getPrimaryKey());

			clearUniqueFindersCache(loan);
		}
	}

	protected void cacheUniqueFindersCache(Loan loan) {
		if (loan.isNew()) {
			Object[] args = new Object[] { loan.getUuid(), loan.getGroupId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args, loan);
		}
		else {
			LoanModelImpl loanModelImpl = (LoanModelImpl)loan;

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { loan.getUuid(), loan.getGroupId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					loan);
			}
		}
	}

	protected void clearUniqueFindersCache(Loan loan) {
		LoanModelImpl loanModelImpl = (LoanModelImpl)loan;

		Object[] args = new Object[] { loan.getUuid(), loan.getGroupId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((loanModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					loanModelImpl.getOriginalUuid(),
					loanModelImpl.getOriginalGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new loan with the primary key. Does not add the loan to the database.
	 *
	 * @param loanId the primary key for the new loan
	 * @return the new loan
	 */
	@Override
	public Loan create(long loanId) {
		Loan loan = new LoanImpl();

		loan.setNew(true);
		loan.setPrimaryKey(loanId);

		String uuid = PortalUUIDUtil.generate();

		loan.setUuid(uuid);

		return loan;
	}

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan that was removed
	 * @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan remove(long loanId) throws NoSuchLoanException, SystemException {
		return remove((Serializable)loanId);
	}

	/**
	 * Removes the loan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan that was removed
	 * @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan remove(Serializable primaryKey)
		throws NoSuchLoanException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Loan loan = (Loan)session.get(LoanImpl.class, primaryKey);

			if (loan == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(loan);
		}
		catch (NoSuchLoanException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Loan removeImpl(Loan loan) throws SystemException {
		loan = toUnwrappedModel(loan);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(loan)) {
				loan = (Loan)session.get(LoanImpl.class, loan.getPrimaryKeyObj());
			}

			if (loan != null) {
				session.delete(loan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (loan != null) {
			clearCache(loan);
		}

		return loan;
	}

	@Override
	public Loan updateImpl(com.imsw.model.Loan loan) throws SystemException {
		loan = toUnwrappedModel(loan);

		boolean isNew = loan.isNew();

		LoanModelImpl loanModelImpl = (LoanModelImpl)loan;

		if (Validator.isNull(loan.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			loan.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (loan.isNew()) {
				session.save(loan);

				loan.setNew(false);
			}
			else {
				session.merge(loan);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LoanModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { loanModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { loanModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalUuid(),
						loanModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						loanModelImpl.getUuid(), loanModelImpl.getCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B_B.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalGroupId(),
						loanModelImpl.getOriginalBookId(),
						loanModelImpl.getOriginalBorrowerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_B_B, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B_B,
					args);

				args = new Object[] {
						loanModelImpl.getGroupId(), loanModelImpl.getBookId(),
						loanModelImpl.getBorrowerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_B_B, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B_B,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_BR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalGroupId(),
						loanModelImpl.getOriginalBorrowerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_BR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_BR,
					args);

				args = new Object[] {
						loanModelImpl.getGroupId(),
						loanModelImpl.getBorrowerId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_BR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_BR,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						loanModelImpl.getOriginalGroupId(),
						loanModelImpl.getOriginalBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_B, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B,
					args);

				args = new Object[] {
						loanModelImpl.getGroupId(), loanModelImpl.getBookId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_B, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_B,
					args);
			}

			if ((loanModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { loanModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { loanModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
			LoanImpl.class, loan.getPrimaryKey(), loan);

		clearUniqueFindersCache(loan);
		cacheUniqueFindersCache(loan);

		return loan;
	}

	protected Loan toUnwrappedModel(Loan loan) {
		if (loan instanceof LoanImpl) {
			return loan;
		}

		LoanImpl loanImpl = new LoanImpl();

		loanImpl.setNew(loan.isNew());
		loanImpl.setPrimaryKey(loan.getPrimaryKey());

		loanImpl.setUuid(loan.getUuid());
		loanImpl.setLoanId(loan.getLoanId());
		loanImpl.setGroupId(loan.getGroupId());
		loanImpl.setCompanyId(loan.getCompanyId());
		loanImpl.setUserId(loan.getUserId());
		loanImpl.setUserName(loan.getUserName());
		loanImpl.setCreateDate(loan.getCreateDate());
		loanImpl.setModifiedDate(loan.getModifiedDate());
		loanImpl.setDateStart(loan.getDateStart());
		loanImpl.setDateFinish(loan.getDateFinish());
		loanImpl.setBorrowerId(loan.getBorrowerId());
		loanImpl.setBookId(loan.getBookId());

		return loanImpl;
	}

	/**
	 * Returns the loan with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan
	 * @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLoanException, SystemException {
		Loan loan = fetchByPrimaryKey(primaryKey);

		if (loan == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLoanException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return loan;
	}

	/**
	 * Returns the loan with the primary key or throws a {@link com.imsw.NoSuchLoanException} if it could not be found.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan
	 * @throws com.imsw.NoSuchLoanException if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan findByPrimaryKey(long loanId)
		throws NoSuchLoanException, SystemException {
		return findByPrimaryKey((Serializable)loanId);
	}

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Loan loan = (Loan)EntityCacheUtil.getResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
				LoanImpl.class, primaryKey);

		if (loan == _nullLoan) {
			return null;
		}

		if (loan == null) {
			Session session = null;

			try {
				session = openSession();

				loan = (Loan)session.get(LoanImpl.class, primaryKey);

				if (loan != null) {
					cacheResult(loan);
				}
				else {
					EntityCacheUtil.putResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
						LoanImpl.class, primaryKey, _nullLoan);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LoanModelImpl.ENTITY_CACHE_ENABLED,
					LoanImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return loan;
	}

	/**
	 * Returns the loan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param loanId the primary key of the loan
	 * @return the loan, or <code>null</code> if a loan with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Loan fetchByPrimaryKey(long loanId) throws SystemException {
		return fetchByPrimaryKey((Serializable)loanId);
	}

	/**
	 * Returns all the loans.
	 *
	 * @return the loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Loan> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Loan> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Loan> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Loan> list = (List<Loan>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOAN);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOAN;

				if (pagination) {
					sql = sql.concat(LoanModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Loan>(list);
				}
				else {
					list = (List<Loan>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the loans from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Loan loan : findAll()) {
			remove(loan);
		}
	}

	/**
	 * Returns the number of loans.
	 *
	 * @return the number of loans
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOAN);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the loan persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.imsw.model.Loan")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Loan>> listenersList = new ArrayList<ModelListener<Loan>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Loan>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LoanImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LOAN = "SELECT loan FROM Loan loan";
	private static final String _SQL_SELECT_LOAN_WHERE = "SELECT loan FROM Loan loan WHERE ";
	private static final String _SQL_COUNT_LOAN = "SELECT COUNT(loan) FROM Loan loan";
	private static final String _SQL_COUNT_LOAN_WHERE = "SELECT COUNT(loan) FROM Loan loan WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "loan.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Loan exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Loan exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LoanPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static Loan _nullLoan = new LoanImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Loan> toCacheModel() {
				return _nullLoanCacheModel;
			}
		};

	private static CacheModel<Loan> _nullLoanCacheModel = new CacheModel<Loan>() {
			@Override
			public Loan toEntityModel() {
				return _nullLoan;
			}
		};
}
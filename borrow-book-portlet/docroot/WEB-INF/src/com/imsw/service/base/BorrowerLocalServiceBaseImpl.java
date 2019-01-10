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

package com.imsw.service.base;

import com.imsw.model.Borrower;

import com.imsw.service.BorrowerLocalService;
import com.imsw.service.persistence.AuthorPersistence;
import com.imsw.service.persistence.BookPersistence;
import com.imsw.service.persistence.BorrowerPersistence;
import com.imsw.service.persistence.LoanPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the borrower local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.imsw.service.impl.BorrowerLocalServiceImpl}.
 * </p>
 *
 * @author User
 * @see com.imsw.service.impl.BorrowerLocalServiceImpl
 * @see com.imsw.service.BorrowerLocalServiceUtil
 * @generated
 */
public abstract class BorrowerLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements BorrowerLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.imsw.service.BorrowerLocalServiceUtil} to access the borrower local service.
	 */

	/**
	 * Adds the borrower to the database. Also notifies the appropriate model listeners.
	 *
	 * @param borrower the borrower
	 * @return the borrower that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Borrower addBorrower(Borrower borrower) throws SystemException {
		borrower.setNew(true);

		return borrowerPersistence.update(borrower);
	}

	/**
	 * Creates a new borrower with the primary key. Does not add the borrower to the database.
	 *
	 * @param borrowerId the primary key for the new borrower
	 * @return the new borrower
	 */
	@Override
	public Borrower createBorrower(long borrowerId) {
		return borrowerPersistence.create(borrowerId);
	}

	/**
	 * Deletes the borrower with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param borrowerId the primary key of the borrower
	 * @return the borrower that was removed
	 * @throws PortalException if a borrower with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Borrower deleteBorrower(long borrowerId)
		throws PortalException, SystemException {
		return borrowerPersistence.remove(borrowerId);
	}

	/**
	 * Deletes the borrower from the database. Also notifies the appropriate model listeners.
	 *
	 * @param borrower the borrower
	 * @return the borrower that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Borrower deleteBorrower(Borrower borrower) throws SystemException {
		return borrowerPersistence.remove(borrower);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Borrower.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return borrowerPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return borrowerPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return borrowerPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return borrowerPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return borrowerPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Borrower fetchBorrower(long borrowerId) throws SystemException {
		return borrowerPersistence.fetchByPrimaryKey(borrowerId);
	}

	/**
	 * Returns the borrower with the matching UUID and company.
	 *
	 * @param uuid the borrower's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching borrower, or <code>null</code> if a matching borrower could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Borrower fetchBorrowerByUuidAndCompanyId(String uuid, long companyId)
		throws SystemException {
		return borrowerPersistence.fetchByUuid_C_First(uuid, companyId, null);
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
	public Borrower fetchBorrowerByUuidAndGroupId(String uuid, long groupId)
		throws SystemException {
		return borrowerPersistence.fetchByUUID_G(uuid, groupId);
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
	public Borrower getBorrower(long borrowerId)
		throws PortalException, SystemException {
		return borrowerPersistence.findByPrimaryKey(borrowerId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return borrowerPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns the borrower with the matching UUID and company.
	 *
	 * @param uuid the borrower's UUID
	 * @param  companyId the primary key of the company
	 * @return the matching borrower
	 * @throws PortalException if a matching borrower could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Borrower getBorrowerByUuidAndCompanyId(String uuid, long companyId)
		throws PortalException, SystemException {
		return borrowerPersistence.findByUuid_C_First(uuid, companyId, null);
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
	public Borrower getBorrowerByUuidAndGroupId(String uuid, long groupId)
		throws PortalException, SystemException {
		return borrowerPersistence.findByUUID_G(uuid, groupId);
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
	public List<Borrower> getBorrowers(int start, int end)
		throws SystemException {
		return borrowerPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of borrowers.
	 *
	 * @return the number of borrowers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getBorrowersCount() throws SystemException {
		return borrowerPersistence.countAll();
	}

	/**
	 * Updates the borrower in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param borrower the borrower
	 * @return the borrower that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Borrower updateBorrower(Borrower borrower) throws SystemException {
		return borrowerPersistence.update(borrower);
	}

	/**
	 * Returns the author local service.
	 *
	 * @return the author local service
	 */
	public com.imsw.service.AuthorLocalService getAuthorLocalService() {
		return authorLocalService;
	}

	/**
	 * Sets the author local service.
	 *
	 * @param authorLocalService the author local service
	 */
	public void setAuthorLocalService(
		com.imsw.service.AuthorLocalService authorLocalService) {
		this.authorLocalService = authorLocalService;
	}

	/**
	 * Returns the author remote service.
	 *
	 * @return the author remote service
	 */
	public com.imsw.service.AuthorService getAuthorService() {
		return authorService;
	}

	/**
	 * Sets the author remote service.
	 *
	 * @param authorService the author remote service
	 */
	public void setAuthorService(com.imsw.service.AuthorService authorService) {
		this.authorService = authorService;
	}

	/**
	 * Returns the author persistence.
	 *
	 * @return the author persistence
	 */
	public AuthorPersistence getAuthorPersistence() {
		return authorPersistence;
	}

	/**
	 * Sets the author persistence.
	 *
	 * @param authorPersistence the author persistence
	 */
	public void setAuthorPersistence(AuthorPersistence authorPersistence) {
		this.authorPersistence = authorPersistence;
	}

	/**
	 * Returns the book local service.
	 *
	 * @return the book local service
	 */
	public com.imsw.service.BookLocalService getBookLocalService() {
		return bookLocalService;
	}

	/**
	 * Sets the book local service.
	 *
	 * @param bookLocalService the book local service
	 */
	public void setBookLocalService(
		com.imsw.service.BookLocalService bookLocalService) {
		this.bookLocalService = bookLocalService;
	}

	/**
	 * Returns the book remote service.
	 *
	 * @return the book remote service
	 */
	public com.imsw.service.BookService getBookService() {
		return bookService;
	}

	/**
	 * Sets the book remote service.
	 *
	 * @param bookService the book remote service
	 */
	public void setBookService(com.imsw.service.BookService bookService) {
		this.bookService = bookService;
	}

	/**
	 * Returns the book persistence.
	 *
	 * @return the book persistence
	 */
	public BookPersistence getBookPersistence() {
		return bookPersistence;
	}

	/**
	 * Sets the book persistence.
	 *
	 * @param bookPersistence the book persistence
	 */
	public void setBookPersistence(BookPersistence bookPersistence) {
		this.bookPersistence = bookPersistence;
	}

	/**
	 * Returns the borrower local service.
	 *
	 * @return the borrower local service
	 */
	public com.imsw.service.BorrowerLocalService getBorrowerLocalService() {
		return borrowerLocalService;
	}

	/**
	 * Sets the borrower local service.
	 *
	 * @param borrowerLocalService the borrower local service
	 */
	public void setBorrowerLocalService(
		com.imsw.service.BorrowerLocalService borrowerLocalService) {
		this.borrowerLocalService = borrowerLocalService;
	}

	/**
	 * Returns the borrower remote service.
	 *
	 * @return the borrower remote service
	 */
	public com.imsw.service.BorrowerService getBorrowerService() {
		return borrowerService;
	}

	/**
	 * Sets the borrower remote service.
	 *
	 * @param borrowerService the borrower remote service
	 */
	public void setBorrowerService(
		com.imsw.service.BorrowerService borrowerService) {
		this.borrowerService = borrowerService;
	}

	/**
	 * Returns the borrower persistence.
	 *
	 * @return the borrower persistence
	 */
	public BorrowerPersistence getBorrowerPersistence() {
		return borrowerPersistence;
	}

	/**
	 * Sets the borrower persistence.
	 *
	 * @param borrowerPersistence the borrower persistence
	 */
	public void setBorrowerPersistence(BorrowerPersistence borrowerPersistence) {
		this.borrowerPersistence = borrowerPersistence;
	}

	/**
	 * Returns the loan local service.
	 *
	 * @return the loan local service
	 */
	public com.imsw.service.LoanLocalService getLoanLocalService() {
		return loanLocalService;
	}

	/**
	 * Sets the loan local service.
	 *
	 * @param loanLocalService the loan local service
	 */
	public void setLoanLocalService(
		com.imsw.service.LoanLocalService loanLocalService) {
		this.loanLocalService = loanLocalService;
	}

	/**
	 * Returns the loan remote service.
	 *
	 * @return the loan remote service
	 */
	public com.imsw.service.LoanService getLoanService() {
		return loanService;
	}

	/**
	 * Sets the loan remote service.
	 *
	 * @param loanService the loan remote service
	 */
	public void setLoanService(com.imsw.service.LoanService loanService) {
		this.loanService = loanService;
	}

	/**
	 * Returns the loan persistence.
	 *
	 * @return the loan persistence
	 */
	public LoanPersistence getLoanPersistence() {
		return loanPersistence;
	}

	/**
	 * Sets the loan persistence.
	 *
	 * @param loanPersistence the loan persistence
	 */
	public void setLoanPersistence(LoanPersistence loanPersistence) {
		this.loanPersistence = loanPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.imsw.model.Borrower",
			borrowerLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.imsw.model.Borrower");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return Borrower.class;
	}

	protected String getModelClassName() {
		return Borrower.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = borrowerPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.imsw.service.AuthorLocalService.class)
	protected com.imsw.service.AuthorLocalService authorLocalService;
	@BeanReference(type = com.imsw.service.AuthorService.class)
	protected com.imsw.service.AuthorService authorService;
	@BeanReference(type = AuthorPersistence.class)
	protected AuthorPersistence authorPersistence;
	@BeanReference(type = com.imsw.service.BookLocalService.class)
	protected com.imsw.service.BookLocalService bookLocalService;
	@BeanReference(type = com.imsw.service.BookService.class)
	protected com.imsw.service.BookService bookService;
	@BeanReference(type = BookPersistence.class)
	protected BookPersistence bookPersistence;
	@BeanReference(type = com.imsw.service.BorrowerLocalService.class)
	protected com.imsw.service.BorrowerLocalService borrowerLocalService;
	@BeanReference(type = com.imsw.service.BorrowerService.class)
	protected com.imsw.service.BorrowerService borrowerService;
	@BeanReference(type = BorrowerPersistence.class)
	protected BorrowerPersistence borrowerPersistence;
	@BeanReference(type = com.imsw.service.LoanLocalService.class)
	protected com.imsw.service.LoanLocalService loanLocalService;
	@BeanReference(type = com.imsw.service.LoanService.class)
	protected com.imsw.service.LoanService loanService;
	@BeanReference(type = LoanPersistence.class)
	protected LoanPersistence loanPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private BorrowerLocalServiceClpInvoker _clpInvoker = new BorrowerLocalServiceClpInvoker();
}
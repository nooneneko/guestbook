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

package com.imsw.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Loan}.
 * </p>
 *
 * @author User
 * @see Loan
 * @generated
 */
public class LoanWrapper implements Loan, ModelWrapper<Loan> {
	public LoanWrapper(Loan loan) {
		_loan = loan;
	}

	@Override
	public Class<?> getModelClass() {
		return Loan.class;
	}

	@Override
	public String getModelClassName() {
		return Loan.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("loanId", getLoanId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dateStart", getDateStart());
		attributes.put("dateFinish", getDateFinish());
		attributes.put("borrowerId", getBorrowerId());
		attributes.put("bookId", getBookId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dateStart = (Date)attributes.get("dateStart");

		if (dateStart != null) {
			setDateStart(dateStart);
		}

		Date dateFinish = (Date)attributes.get("dateFinish");

		if (dateFinish != null) {
			setDateFinish(dateFinish);
		}

		Long borrowerId = (Long)attributes.get("borrowerId");

		if (borrowerId != null) {
			setBorrowerId(borrowerId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}
	}

	/**
	* Returns the primary key of this loan.
	*
	* @return the primary key of this loan
	*/
	@Override
	public long getPrimaryKey() {
		return _loan.getPrimaryKey();
	}

	/**
	* Sets the primary key of this loan.
	*
	* @param primaryKey the primary key of this loan
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_loan.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this loan.
	*
	* @return the uuid of this loan
	*/
	@Override
	public java.lang.String getUuid() {
		return _loan.getUuid();
	}

	/**
	* Sets the uuid of this loan.
	*
	* @param uuid the uuid of this loan
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_loan.setUuid(uuid);
	}

	/**
	* Returns the loan ID of this loan.
	*
	* @return the loan ID of this loan
	*/
	@Override
	public long getLoanId() {
		return _loan.getLoanId();
	}

	/**
	* Sets the loan ID of this loan.
	*
	* @param loanId the loan ID of this loan
	*/
	@Override
	public void setLoanId(long loanId) {
		_loan.setLoanId(loanId);
	}

	/**
	* Returns the group ID of this loan.
	*
	* @return the group ID of this loan
	*/
	@Override
	public long getGroupId() {
		return _loan.getGroupId();
	}

	/**
	* Sets the group ID of this loan.
	*
	* @param groupId the group ID of this loan
	*/
	@Override
	public void setGroupId(long groupId) {
		_loan.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this loan.
	*
	* @return the company ID of this loan
	*/
	@Override
	public long getCompanyId() {
		return _loan.getCompanyId();
	}

	/**
	* Sets the company ID of this loan.
	*
	* @param companyId the company ID of this loan
	*/
	@Override
	public void setCompanyId(long companyId) {
		_loan.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this loan.
	*
	* @return the user ID of this loan
	*/
	@Override
	public long getUserId() {
		return _loan.getUserId();
	}

	/**
	* Sets the user ID of this loan.
	*
	* @param userId the user ID of this loan
	*/
	@Override
	public void setUserId(long userId) {
		_loan.setUserId(userId);
	}

	/**
	* Returns the user uuid of this loan.
	*
	* @return the user uuid of this loan
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _loan.getUserUuid();
	}

	/**
	* Sets the user uuid of this loan.
	*
	* @param userUuid the user uuid of this loan
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_loan.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this loan.
	*
	* @return the user name of this loan
	*/
	@Override
	public java.lang.String getUserName() {
		return _loan.getUserName();
	}

	/**
	* Sets the user name of this loan.
	*
	* @param userName the user name of this loan
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_loan.setUserName(userName);
	}

	/**
	* Returns the create date of this loan.
	*
	* @return the create date of this loan
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _loan.getCreateDate();
	}

	/**
	* Sets the create date of this loan.
	*
	* @param createDate the create date of this loan
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_loan.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this loan.
	*
	* @return the modified date of this loan
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _loan.getModifiedDate();
	}

	/**
	* Sets the modified date of this loan.
	*
	* @param modifiedDate the modified date of this loan
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_loan.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the date start of this loan.
	*
	* @return the date start of this loan
	*/
	@Override
	public java.util.Date getDateStart() {
		return _loan.getDateStart();
	}

	/**
	* Sets the date start of this loan.
	*
	* @param dateStart the date start of this loan
	*/
	@Override
	public void setDateStart(java.util.Date dateStart) {
		_loan.setDateStart(dateStart);
	}

	/**
	* Returns the date finish of this loan.
	*
	* @return the date finish of this loan
	*/
	@Override
	public java.util.Date getDateFinish() {
		return _loan.getDateFinish();
	}

	/**
	* Sets the date finish of this loan.
	*
	* @param dateFinish the date finish of this loan
	*/
	@Override
	public void setDateFinish(java.util.Date dateFinish) {
		_loan.setDateFinish(dateFinish);
	}

	/**
	* Returns the borrower ID of this loan.
	*
	* @return the borrower ID of this loan
	*/
	@Override
	public long getBorrowerId() {
		return _loan.getBorrowerId();
	}

	/**
	* Sets the borrower ID of this loan.
	*
	* @param borrowerId the borrower ID of this loan
	*/
	@Override
	public void setBorrowerId(long borrowerId) {
		_loan.setBorrowerId(borrowerId);
	}

	/**
	* Returns the book ID of this loan.
	*
	* @return the book ID of this loan
	*/
	@Override
	public long getBookId() {
		return _loan.getBookId();
	}

	/**
	* Sets the book ID of this loan.
	*
	* @param bookId the book ID of this loan
	*/
	@Override
	public void setBookId(long bookId) {
		_loan.setBookId(bookId);
	}

	@Override
	public boolean isNew() {
		return _loan.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_loan.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _loan.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_loan.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _loan.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _loan.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_loan.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _loan.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_loan.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_loan.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_loan.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LoanWrapper((Loan)_loan.clone());
	}

	@Override
	public int compareTo(com.imsw.model.Loan loan) {
		return _loan.compareTo(loan);
	}

	@Override
	public int hashCode() {
		return _loan.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.imsw.model.Loan> toCacheModel() {
		return _loan.toCacheModel();
	}

	@Override
	public com.imsw.model.Loan toEscapedModel() {
		return new LoanWrapper(_loan.toEscapedModel());
	}

	@Override
	public com.imsw.model.Loan toUnescapedModel() {
		return new LoanWrapper(_loan.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _loan.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _loan.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_loan.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanWrapper)) {
			return false;
		}

		LoanWrapper loanWrapper = (LoanWrapper)obj;

		if (Validator.equals(_loan, loanWrapper._loan)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _loan.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Loan getWrappedLoan() {
		return _loan;
	}

	@Override
	public Loan getWrappedModel() {
		return _loan;
	}

	@Override
	public void resetOriginalValues() {
		_loan.resetOriginalValues();
	}

	private Loan _loan;
}
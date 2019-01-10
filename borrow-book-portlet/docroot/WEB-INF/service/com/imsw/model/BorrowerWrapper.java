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
 * This class is a wrapper for {@link Borrower}.
 * </p>
 *
 * @author User
 * @see Borrower
 * @generated
 */
public class BorrowerWrapper implements Borrower, ModelWrapper<Borrower> {
	public BorrowerWrapper(Borrower borrower) {
		_borrower = borrower;
	}

	@Override
	public Class<?> getModelClass() {
		return Borrower.class;
	}

	@Override
	public String getModelClassName() {
		return Borrower.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("borrowerId", getBorrowerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("email", getEmail());
		attributes.put("PhoneNo", getPhoneNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long borrowerId = (Long)attributes.get("borrowerId");

		if (borrowerId != null) {
			setBorrowerId(borrowerId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String PhoneNo = (String)attributes.get("PhoneNo");

		if (PhoneNo != null) {
			setPhoneNo(PhoneNo);
		}
	}

	/**
	* Returns the primary key of this borrower.
	*
	* @return the primary key of this borrower
	*/
	@Override
	public long getPrimaryKey() {
		return _borrower.getPrimaryKey();
	}

	/**
	* Sets the primary key of this borrower.
	*
	* @param primaryKey the primary key of this borrower
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_borrower.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this borrower.
	*
	* @return the uuid of this borrower
	*/
	@Override
	public java.lang.String getUuid() {
		return _borrower.getUuid();
	}

	/**
	* Sets the uuid of this borrower.
	*
	* @param uuid the uuid of this borrower
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_borrower.setUuid(uuid);
	}

	/**
	* Returns the borrower ID of this borrower.
	*
	* @return the borrower ID of this borrower
	*/
	@Override
	public long getBorrowerId() {
		return _borrower.getBorrowerId();
	}

	/**
	* Sets the borrower ID of this borrower.
	*
	* @param borrowerId the borrower ID of this borrower
	*/
	@Override
	public void setBorrowerId(long borrowerId) {
		_borrower.setBorrowerId(borrowerId);
	}

	/**
	* Returns the group ID of this borrower.
	*
	* @return the group ID of this borrower
	*/
	@Override
	public long getGroupId() {
		return _borrower.getGroupId();
	}

	/**
	* Sets the group ID of this borrower.
	*
	* @param groupId the group ID of this borrower
	*/
	@Override
	public void setGroupId(long groupId) {
		_borrower.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this borrower.
	*
	* @return the company ID of this borrower
	*/
	@Override
	public long getCompanyId() {
		return _borrower.getCompanyId();
	}

	/**
	* Sets the company ID of this borrower.
	*
	* @param companyId the company ID of this borrower
	*/
	@Override
	public void setCompanyId(long companyId) {
		_borrower.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this borrower.
	*
	* @return the user ID of this borrower
	*/
	@Override
	public long getUserId() {
		return _borrower.getUserId();
	}

	/**
	* Sets the user ID of this borrower.
	*
	* @param userId the user ID of this borrower
	*/
	@Override
	public void setUserId(long userId) {
		_borrower.setUserId(userId);
	}

	/**
	* Returns the user uuid of this borrower.
	*
	* @return the user uuid of this borrower
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _borrower.getUserUuid();
	}

	/**
	* Sets the user uuid of this borrower.
	*
	* @param userUuid the user uuid of this borrower
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_borrower.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this borrower.
	*
	* @return the user name of this borrower
	*/
	@Override
	public java.lang.String getUserName() {
		return _borrower.getUserName();
	}

	/**
	* Sets the user name of this borrower.
	*
	* @param userName the user name of this borrower
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_borrower.setUserName(userName);
	}

	/**
	* Returns the create date of this borrower.
	*
	* @return the create date of this borrower
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _borrower.getCreateDate();
	}

	/**
	* Sets the create date of this borrower.
	*
	* @param createDate the create date of this borrower
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_borrower.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this borrower.
	*
	* @return the modified date of this borrower
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _borrower.getModifiedDate();
	}

	/**
	* Sets the modified date of this borrower.
	*
	* @param modifiedDate the modified date of this borrower
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_borrower.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this borrower.
	*
	* @return the name of this borrower
	*/
	@Override
	public java.lang.String getName() {
		return _borrower.getName();
	}

	/**
	* Sets the name of this borrower.
	*
	* @param name the name of this borrower
	*/
	@Override
	public void setName(java.lang.String name) {
		_borrower.setName(name);
	}

	/**
	* Returns the address of this borrower.
	*
	* @return the address of this borrower
	*/
	@Override
	public java.lang.String getAddress() {
		return _borrower.getAddress();
	}

	/**
	* Sets the address of this borrower.
	*
	* @param address the address of this borrower
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_borrower.setAddress(address);
	}

	/**
	* Returns the city of this borrower.
	*
	* @return the city of this borrower
	*/
	@Override
	public java.lang.String getCity() {
		return _borrower.getCity();
	}

	/**
	* Sets the city of this borrower.
	*
	* @param city the city of this borrower
	*/
	@Override
	public void setCity(java.lang.String city) {
		_borrower.setCity(city);
	}

	/**
	* Returns the email of this borrower.
	*
	* @return the email of this borrower
	*/
	@Override
	public java.lang.String getEmail() {
		return _borrower.getEmail();
	}

	/**
	* Sets the email of this borrower.
	*
	* @param email the email of this borrower
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_borrower.setEmail(email);
	}

	/**
	* Returns the phone no of this borrower.
	*
	* @return the phone no of this borrower
	*/
	@Override
	public java.lang.String getPhoneNo() {
		return _borrower.getPhoneNo();
	}

	/**
	* Sets the phone no of this borrower.
	*
	* @param PhoneNo the phone no of this borrower
	*/
	@Override
	public void setPhoneNo(java.lang.String PhoneNo) {
		_borrower.setPhoneNo(PhoneNo);
	}

	@Override
	public boolean isNew() {
		return _borrower.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_borrower.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _borrower.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_borrower.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _borrower.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _borrower.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_borrower.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _borrower.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_borrower.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_borrower.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_borrower.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BorrowerWrapper((Borrower)_borrower.clone());
	}

	@Override
	public int compareTo(com.imsw.model.Borrower borrower) {
		return _borrower.compareTo(borrower);
	}

	@Override
	public int hashCode() {
		return _borrower.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.imsw.model.Borrower> toCacheModel() {
		return _borrower.toCacheModel();
	}

	@Override
	public com.imsw.model.Borrower toEscapedModel() {
		return new BorrowerWrapper(_borrower.toEscapedModel());
	}

	@Override
	public com.imsw.model.Borrower toUnescapedModel() {
		return new BorrowerWrapper(_borrower.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _borrower.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _borrower.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_borrower.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BorrowerWrapper)) {
			return false;
		}

		BorrowerWrapper borrowerWrapper = (BorrowerWrapper)obj;

		if (Validator.equals(_borrower, borrowerWrapper._borrower)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _borrower.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Borrower getWrappedBorrower() {
		return _borrower;
	}

	@Override
	public Borrower getWrappedModel() {
		return _borrower;
	}

	@Override
	public void resetOriginalValues() {
		_borrower.resetOriginalValues();
	}

	private Borrower _borrower;
}
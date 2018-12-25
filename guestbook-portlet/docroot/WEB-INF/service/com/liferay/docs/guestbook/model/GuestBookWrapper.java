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

package com.liferay.docs.guestbook.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GuestBook}.
 * </p>
 *
 * @author User
 * @see GuestBook
 * @generated
 */
public class GuestBookWrapper implements GuestBook, ModelWrapper<GuestBook> {
	public GuestBookWrapper(GuestBook guestBook) {
		_guestBook = guestBook;
	}

	@Override
	public Class<?> getModelClass() {
		return GuestBook.class;
	}

	@Override
	public String getModelClassName() {
		return GuestBook.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("guestBookId", getGuestBookId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long guestBookId = (Long)attributes.get("guestBookId");

		if (guestBookId != null) {
			setGuestBookId(guestBookId);
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
	}

	/**
	* Returns the primary key of this guest book.
	*
	* @return the primary key of this guest book
	*/
	@Override
	public long getPrimaryKey() {
		return _guestBook.getPrimaryKey();
	}

	/**
	* Sets the primary key of this guest book.
	*
	* @param primaryKey the primary key of this guest book
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_guestBook.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this guest book.
	*
	* @return the uuid of this guest book
	*/
	@Override
	public java.lang.String getUuid() {
		return _guestBook.getUuid();
	}

	/**
	* Sets the uuid of this guest book.
	*
	* @param uuid the uuid of this guest book
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_guestBook.setUuid(uuid);
	}

	/**
	* Returns the guest book ID of this guest book.
	*
	* @return the guest book ID of this guest book
	*/
	@Override
	public long getGuestBookId() {
		return _guestBook.getGuestBookId();
	}

	/**
	* Sets the guest book ID of this guest book.
	*
	* @param guestBookId the guest book ID of this guest book
	*/
	@Override
	public void setGuestBookId(long guestBookId) {
		_guestBook.setGuestBookId(guestBookId);
	}

	/**
	* Returns the group ID of this guest book.
	*
	* @return the group ID of this guest book
	*/
	@Override
	public long getGroupId() {
		return _guestBook.getGroupId();
	}

	/**
	* Sets the group ID of this guest book.
	*
	* @param groupId the group ID of this guest book
	*/
	@Override
	public void setGroupId(long groupId) {
		_guestBook.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this guest book.
	*
	* @return the company ID of this guest book
	*/
	@Override
	public long getCompanyId() {
		return _guestBook.getCompanyId();
	}

	/**
	* Sets the company ID of this guest book.
	*
	* @param companyId the company ID of this guest book
	*/
	@Override
	public void setCompanyId(long companyId) {
		_guestBook.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this guest book.
	*
	* @return the user ID of this guest book
	*/
	@Override
	public long getUserId() {
		return _guestBook.getUserId();
	}

	/**
	* Sets the user ID of this guest book.
	*
	* @param userId the user ID of this guest book
	*/
	@Override
	public void setUserId(long userId) {
		_guestBook.setUserId(userId);
	}

	/**
	* Returns the user uuid of this guest book.
	*
	* @return the user uuid of this guest book
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guestBook.getUserUuid();
	}

	/**
	* Sets the user uuid of this guest book.
	*
	* @param userUuid the user uuid of this guest book
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_guestBook.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this guest book.
	*
	* @return the user name of this guest book
	*/
	@Override
	public java.lang.String getUserName() {
		return _guestBook.getUserName();
	}

	/**
	* Sets the user name of this guest book.
	*
	* @param userName the user name of this guest book
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_guestBook.setUserName(userName);
	}

	/**
	* Returns the create date of this guest book.
	*
	* @return the create date of this guest book
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _guestBook.getCreateDate();
	}

	/**
	* Sets the create date of this guest book.
	*
	* @param createDate the create date of this guest book
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_guestBook.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this guest book.
	*
	* @return the modified date of this guest book
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _guestBook.getModifiedDate();
	}

	/**
	* Sets the modified date of this guest book.
	*
	* @param modifiedDate the modified date of this guest book
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_guestBook.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this guest book.
	*
	* @return the name of this guest book
	*/
	@Override
	public java.lang.String getName() {
		return _guestBook.getName();
	}

	/**
	* Sets the name of this guest book.
	*
	* @param name the name of this guest book
	*/
	@Override
	public void setName(java.lang.String name) {
		_guestBook.setName(name);
	}

	@Override
	public boolean isNew() {
		return _guestBook.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_guestBook.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _guestBook.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_guestBook.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _guestBook.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _guestBook.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_guestBook.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _guestBook.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_guestBook.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_guestBook.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_guestBook.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GuestBookWrapper((GuestBook)_guestBook.clone());
	}

	@Override
	public int compareTo(com.liferay.docs.guestbook.model.GuestBook guestBook) {
		return _guestBook.compareTo(guestBook);
	}

	@Override
	public int hashCode() {
		return _guestBook.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.docs.guestbook.model.GuestBook> toCacheModel() {
		return _guestBook.toCacheModel();
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook toEscapedModel() {
		return new GuestBookWrapper(_guestBook.toEscapedModel());
	}

	@Override
	public com.liferay.docs.guestbook.model.GuestBook toUnescapedModel() {
		return new GuestBookWrapper(_guestBook.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _guestBook.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _guestBook.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_guestBook.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GuestBookWrapper)) {
			return false;
		}

		GuestBookWrapper guestBookWrapper = (GuestBookWrapper)obj;

		if (Validator.equals(_guestBook, guestBookWrapper._guestBook)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _guestBook.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GuestBook getWrappedGuestBook() {
		return _guestBook;
	}

	@Override
	public GuestBook getWrappedModel() {
		return _guestBook;
	}

	@Override
	public void resetOriginalValues() {
		_guestBook.resetOriginalValues();
	}

	private GuestBook _guestBook;
}
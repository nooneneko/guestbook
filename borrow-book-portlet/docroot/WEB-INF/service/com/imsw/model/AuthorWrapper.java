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
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author User
 * @see Author
 * @generated
 */
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	@Override
	public Class<?> getModelClass() {
		return Author.class;
	}

	@Override
	public String getModelClassName() {
		return Author.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("authorId", getAuthorId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
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

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	/**
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	@Override
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this author.
	*
	* @return the uuid of this author
	*/
	@Override
	public java.lang.String getUuid() {
		return _author.getUuid();
	}

	/**
	* Sets the uuid of this author.
	*
	* @param uuid the uuid of this author
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_author.setUuid(uuid);
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	@Override
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	@Override
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	/**
	* Returns the group ID of this author.
	*
	* @return the group ID of this author
	*/
	@Override
	public long getGroupId() {
		return _author.getGroupId();
	}

	/**
	* Sets the group ID of this author.
	*
	* @param groupId the group ID of this author
	*/
	@Override
	public void setGroupId(long groupId) {
		_author.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this author.
	*
	* @return the company ID of this author
	*/
	@Override
	public long getCompanyId() {
		return _author.getCompanyId();
	}

	/**
	* Sets the company ID of this author.
	*
	* @param companyId the company ID of this author
	*/
	@Override
	public void setCompanyId(long companyId) {
		_author.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this author.
	*
	* @return the user ID of this author
	*/
	@Override
	public long getUserId() {
		return _author.getUserId();
	}

	/**
	* Sets the user ID of this author.
	*
	* @param userId the user ID of this author
	*/
	@Override
	public void setUserId(long userId) {
		_author.setUserId(userId);
	}

	/**
	* Returns the user uuid of this author.
	*
	* @return the user uuid of this author
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _author.getUserUuid();
	}

	/**
	* Sets the user uuid of this author.
	*
	* @param userUuid the user uuid of this author
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_author.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this author.
	*
	* @return the user name of this author
	*/
	@Override
	public java.lang.String getUserName() {
		return _author.getUserName();
	}

	/**
	* Sets the user name of this author.
	*
	* @param userName the user name of this author
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_author.setUserName(userName);
	}

	/**
	* Returns the create date of this author.
	*
	* @return the create date of this author
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _author.getCreateDate();
	}

	/**
	* Sets the create date of this author.
	*
	* @param createDate the create date of this author
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_author.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this author.
	*
	* @return the modified date of this author
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _author.getModifiedDate();
	}

	/**
	* Sets the modified date of this author.
	*
	* @param modifiedDate the modified date of this author
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_author.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this author.
	*
	* @return the name of this author
	*/
	@Override
	public java.lang.String getName() {
		return _author.getName();
	}

	/**
	* Sets the name of this author.
	*
	* @param name the name of this author
	*/
	@Override
	public void setName(java.lang.String name) {
		_author.setName(name);
	}

	/**
	* Returns the email of this author.
	*
	* @return the email of this author
	*/
	@Override
	public java.lang.String getEmail() {
		return _author.getEmail();
	}

	/**
	* Sets the email of this author.
	*
	* @param email the email of this author
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_author.setEmail(email);
	}

	/**
	* Returns the address of this author.
	*
	* @return the address of this author
	*/
	@Override
	public java.lang.String getAddress() {
		return _author.getAddress();
	}

	/**
	* Sets the address of this author.
	*
	* @param address the address of this author
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_author.setAddress(address);
	}

	@Override
	public boolean isNew() {
		return _author.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_author.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_author.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_author.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	@Override
	public int compareTo(com.imsw.model.Author author) {
		return _author.compareTo(author);
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.imsw.model.Author> toCacheModel() {
		return _author.toCacheModel();
	}

	@Override
	public com.imsw.model.Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public com.imsw.model.Author toUnescapedModel() {
		return new AuthorWrapper(_author.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _author.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _author.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_author.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorWrapper)) {
			return false;
		}

		AuthorWrapper authorWrapper = (AuthorWrapper)obj;

		if (Validator.equals(_author, authorWrapper._author)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _author.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Author getWrappedAuthor() {
		return _author;
	}

	@Override
	public Author getWrappedModel() {
		return _author;
	}

	@Override
	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private Author _author;
}
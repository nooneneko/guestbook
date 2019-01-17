/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.shopping.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ShoppingCategory service. Represents a row in the &quot;Shopping_ShoppingCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.shopping.model.impl.ShoppingCategoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.shopping.model.impl.ShoppingCategoryImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a shopping category model instance should use the {@link ShoppingCategory} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCategory
 * @see com.liferay.shopping.model.impl.ShoppingCategoryImpl
 * @see com.liferay.shopping.model.impl.ShoppingCategoryModelImpl
 * @generated
 */
public interface ShoppingCategoryModel extends BaseModel<ShoppingCategory> {
	/**
	 * Gets the primary key of this shopping category.
	 *
	 * @return the primary key of this shopping category
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this shopping category
	 *
	 * @param pk the primary key of this shopping category
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the category id of this shopping category.
	 *
	 * @return the category id of this shopping category
	 */
	public long getCategoryId();

	/**
	 * Sets the category id of this shopping category.
	 *
	 * @param categoryId the category id of this shopping category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Gets the group id of this shopping category.
	 *
	 * @return the group id of this shopping category
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this shopping category.
	 *
	 * @param groupId the group id of this shopping category
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this shopping category.
	 *
	 * @return the company id of this shopping category
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this shopping category.
	 *
	 * @param companyId the company id of this shopping category
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this shopping category.
	 *
	 * @return the user id of this shopping category
	 */
	public long getUserId();

	/**
	 * Sets the user id of this shopping category.
	 *
	 * @param userId the user id of this shopping category
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this shopping category.
	 *
	 * @return the user uuid of this shopping category
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this shopping category.
	 *
	 * @param userUuid the user uuid of this shopping category
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this shopping category.
	 *
	 * @return the user name of this shopping category
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this shopping category.
	 *
	 * @param userName the user name of this shopping category
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this shopping category.
	 *
	 * @return the create date of this shopping category
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this shopping category.
	 *
	 * @param createDate the create date of this shopping category
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this shopping category.
	 *
	 * @return the modified date of this shopping category
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this shopping category.
	 *
	 * @param modifiedDate the modified date of this shopping category
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the parent category id of this shopping category.
	 *
	 * @return the parent category id of this shopping category
	 */
	public long getParentCategoryId();

	/**
	 * Sets the parent category id of this shopping category.
	 *
	 * @param parentCategoryId the parent category id of this shopping category
	 */
	public void setParentCategoryId(long parentCategoryId);

	/**
	 * Gets the name of this shopping category.
	 *
	 * @return the name of this shopping category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this shopping category.
	 *
	 * @param name the name of this shopping category
	 */
	public void setName(String name);

	/**
	 * Gets the description of this shopping category.
	 *
	 * @return the description of this shopping category
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this shopping category.
	 *
	 * @param description the description of this shopping category
	 */
	public void setDescription(String description);

	/**
	 * Gets a copy of this shopping category as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ShoppingCategory toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ShoppingCategory shoppingCategory);

	public int hashCode();

	public String toString();

	public String toXmlString();
}
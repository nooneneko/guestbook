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

import com.imsw.service.BorrowerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author User
 * @generated
 */
public abstract class BorrowerActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public BorrowerActionableDynamicQuery() throws SystemException {
		setBaseLocalService(BorrowerLocalServiceUtil.getService());
		setClass(Borrower.class);

		setClassLoader(com.imsw.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("borrowerId");
	}
}
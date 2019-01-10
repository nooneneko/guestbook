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

package com.imsw.service.impl;

import java.util.Date;
import java.util.List;

import com.imsw.AuthorAddressException;
import com.imsw.AuthorEmailException;
import com.imsw.AuthorNameException;
import com.imsw.model.Author;
import com.imsw.service.base.AuthorLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.imsw.service.AuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author User
 * @see com.imsw.service.base.AuthorLocalServiceBaseImpl
 * @see com.imsw.service.AuthorLocalServiceUtil
 */
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.imsw.service.AuthorLocalServiceUtil} to access the author local service.
	 */
	public List<Author> getListAuthors(long groupId) throws SystemException {
		return authorPersistence.findByGroupId(groupId);
	}
	
	public List<Author> getListAuthors(long groupId, int start, int end) throws SystemException {
		return authorPersistence.findByGroupId(groupId, start, end);
	}
	
	public int getAuthorsCount(long groupId) throws SystemException {
		return authorPersistence.countByGroupId(groupId);
	}
	
	public Author addAuthor(long userId, String name, String email, String address, ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		validate(name, email, address);
		
		long authorId = counterLocalService.increment();
		
		Author newAuthor = authorPersistence.create(authorId);
		
		newAuthor.setCompanyId(serviceContext.getCompanyId());
		newAuthor.setGroupId(groupId);
		newAuthor.setUserId(userId);
		newAuthor.setUserName(user.getFullName());
		newAuthor.setUuid(serviceContext.getUuid());
		newAuthor.setCreateDate(serviceContext.getCreateDate(now));
		newAuthor.setModifiedDate(serviceContext.getModifiedDate(now));
		
		newAuthor.setName(name);
		newAuthor.setEmail(email);
		newAuthor.setAddress(address);
		
		newAuthor.setExpandoBridgeAttributes(serviceContext);
		
		authorPersistence.update(newAuthor);
		
		return newAuthor;
	}

	protected void validate(String name, String email, String address) throws PortalException {
		if (!Validator.isAddress(email)) {
			throw new AuthorEmailException();
		}
		
		if (!Validator.isAlphanumericName(name)) {
			throw new AuthorNameException();
		}
		
		if (Validator.isNull(address)) {
			throw new AuthorAddressException();
		}
	}
}
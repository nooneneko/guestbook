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

import com.imsw.BookCostException;
import com.imsw.BookTitleException;
import com.imsw.model.Book;
import com.imsw.service.base.BookLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.imsw.service.BookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author User
 * @see com.imsw.service.base.BookLocalServiceBaseImpl
 * @see com.imsw.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.imsw.service.BookLocalServiceUtil} to access the book local service.
	 */
	public List<Book> getListBooks(long groupId, long authorId) throws SystemException {
		return bookPersistence.findByG_A(groupId, authorId);
	}
	
	public List<Book> getListBooks(long groupId, long authorId, int start, int end) throws SystemException {
		return bookPersistence.findByG_A(groupId, authorId, start, end);
	}
	
	public int countBooks(long groupId, long authorId) throws SystemException {
		return bookPersistence.countByG_A(groupId, authorId);
	}
	
	public Book addBook(long userId, String title, String description, int cost, ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);
		
		long groupId = serviceContext.getScopeGroupId();
		
		Date now = new Date();
		
		validate(title, cost);
		
		long bookId = counterLocalService.increment();
		
		Book newBook = bookPersistence.create(bookId);
		
		newBook.setCompanyId(serviceContext.getCompanyId());
		newBook.setGroupId(groupId);
		newBook.setUserId(userId);
		newBook.setUserName(user.getFullName());
		newBook.setUuid(serviceContext.getUuid());
		newBook.setCreateDate(serviceContext.getCreateDate(now));
		newBook.setModifiedDate(serviceContext.getModifiedDate(now));
		
		newBook.setTitle(title);
		newBook.setDescription(description);
		newBook.setCost(cost);
		
		newBook.setExpandoBridgeAttributes(serviceContext);
		
		return newBook;
	}

	protected void validate(String title, int cost) throws PortalException {
		if (Validator.isNull(cost)) {
			throw new BookCostException();
		}
		
		if (Validator.isNull(title)) {
			throw new BookTitleException();
		}
	}
}
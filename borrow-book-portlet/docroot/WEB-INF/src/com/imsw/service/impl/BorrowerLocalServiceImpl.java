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

import com.imsw.BorrowerAddressException;
import com.imsw.BorrowerCityException;
import com.imsw.BorrowerEmailException;
import com.imsw.BorrowerNameException;
import com.imsw.BorrowerPhoneNoException;
import com.imsw.model.Borrower;
import com.imsw.service.base.BorrowerLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the borrower local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.imsw.service.BorrowerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author User
 * @see com.imsw.service.base.BorrowerLocalServiceBaseImpl
 * @see com.imsw.service.BorrowerLocalServiceUtil
 */
public class BorrowerLocalServiceImpl extends BorrowerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.imsw.service.BorrowerLocalServiceUtil} to access the borrower local service.
	 */
	public List<Borrower> getListBorrowers(long groupId, int start, int end) throws SystemException {
		return borrowerPersistence.findByGroupId(groupId, start, end);
	}
	
	public List<Borrower> getListBorrowers(long groupId) throws SystemException {
		return borrowerPersistence.findByGroupId(groupId);
	}
	
	public int countBorrowers(long groupId) throws SystemException {
		return borrowerPersistence.countByGroupId(groupId);
	}
	
	public Borrower addBorrower(long userId, String name, String email, String address, 
			String city, String phoneNo, ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		long groupId = serviceContext.getScopeGroupId();
		
		validate(name, email, address, city, phoneNo);
		
		long borrowerId = counterLocalService.increment();
		
		Borrower newBorrower = borrowerPersistence.create(borrowerId);
		
		newBorrower.setCompanyId(serviceContext.getCompanyId());
		newBorrower.setGroupId(groupId);
		newBorrower.setUserId(userId);
		newBorrower.setUserName(user.getFullName());
		newBorrower.setUuid(serviceContext.getUuid());
		newBorrower.setCreateDate(serviceContext.getCreateDate(now));
		newBorrower.setModifiedDate(serviceContext.getModifiedDate(now));
		
		newBorrower.setName(name);
		newBorrower.setAddress(address);
		newBorrower.setEmail(email);
		newBorrower.setPhoneNo(phoneNo);
		newBorrower.setCity(city);
		
		newBorrower.setExpandoBridgeAttributes(serviceContext);
		
		borrowerPersistence.update(newBorrower);
		
		return newBorrower;
	}

	protected void validate(String name, String email, 
			String address, String city, String phoneNo) throws PortalException {
		if (Validator.isNull(name)) {
			throw new BorrowerNameException();
		}
		
		if (!Validator.isEmailAddress(email)) {
			throw new BorrowerEmailException();
		}
		
		if (Validator.isNull(address)) {
			throw new BorrowerAddressException();
		}
		
		if (Validator.isNull(city)) {
			throw new BorrowerCityException();
		}
		
		if (!Validator.isPhoneNumber(phoneNo)) {
			throw new BorrowerPhoneNoException();
		}
	}
}
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

import com.imsw.LoanDateFinishException;
import com.imsw.LoanDateStartException;
import com.imsw.model.Loan;
import com.imsw.service.base.LoanLocalServiceBaseImpl;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the loan local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.imsw.service.LoanLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author User
 * @see com.imsw.service.base.LoanLocalServiceBaseImpl
 * @see com.imsw.service.LoanLocalServiceUtil
 */
public class LoanLocalServiceImpl extends LoanLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.imsw.service.LoanLocalServiceUtil} to access the loan local service.
	 */
	
	public List<Loan> getListLoans(long groupId, long borrowerId) throws SystemException {
		return loanPersistence.findByG_Br(groupId, borrowerId);
	}
	
	public List<Loan> getListLoans(long groupId, long borrowerId, int start, int end) throws SystemException {
		return loanPersistence.findByG_Br(groupId, borrowerId, start, end);
	}
	
	public int countLoans(long groupId, long borrowerId) throws SystemException {
		return loanPersistence.countByG_Br(groupId, borrowerId);
	}
	
	public Loan addLoan(long userId, Date dateStart, Date dateFinish, ServiceContext serviceContext) throws PortalException, SystemException {
		User user = userPersistence.findByPrimaryKey(userId);
		
		Date now = new Date();
		
		long groupId = serviceContext.getScopeGroupId();
		
		validate(dateStart, dateFinish);
		
		long loanId = counterLocalService.increment();
		
		Loan loan = loanPersistence.create(loanId);
		
		loan.setCompanyId(serviceContext.getCompanyId());
		loan.setGroupId(groupId);
		loan.setUserId(userId);
		loan.setUserName(user.getFullName());
		loan.setUuid(serviceContext.getUuid());
		loan.setCreateDate(serviceContext.getCreateDate(now));
		loan.setModifiedDate(serviceContext.getModifiedDate(now));
		
		loan.setDateStart(dateStart);
		loan.setDateFinish(dateFinish);
		
		loan.setExpandoBridgeAttributes(serviceContext);
		
		return null;
	}

	protected void validate(Date dateStart, Date dateFinish) throws PortalException {
		if (Validator.isNull(dateStart)) {
			throw new LoanDateStartException();
		}
		
		if (Validator.isNull(dateFinish)) {
			throw new LoanDateFinishException();
		}
	}
}
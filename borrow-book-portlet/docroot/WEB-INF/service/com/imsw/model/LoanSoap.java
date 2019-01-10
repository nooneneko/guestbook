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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.imsw.service.http.LoanServiceSoap}.
 *
 * @author User
 * @see com.imsw.service.http.LoanServiceSoap
 * @generated
 */
public class LoanSoap implements Serializable {
	public static LoanSoap toSoapModel(Loan model) {
		LoanSoap soapModel = new LoanSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLoanId(model.getLoanId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDateStart(model.getDateStart());
		soapModel.setDateFinish(model.getDateFinish());
		soapModel.setBorrowerId(model.getBorrowerId());
		soapModel.setBookId(model.getBookId());

		return soapModel;
	}

	public static LoanSoap[] toSoapModels(Loan[] models) {
		LoanSoap[] soapModels = new LoanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LoanSoap[][] toSoapModels(Loan[][] models) {
		LoanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LoanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LoanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LoanSoap[] toSoapModels(List<Loan> models) {
		List<LoanSoap> soapModels = new ArrayList<LoanSoap>(models.size());

		for (Loan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LoanSoap[soapModels.size()]);
	}

	public LoanSoap() {
	}

	public long getPrimaryKey() {
		return _loanId;
	}

	public void setPrimaryKey(long pk) {
		setLoanId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLoanId() {
		return _loanId;
	}

	public void setLoanId(long loanId) {
		_loanId = loanId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getDateStart() {
		return _dateStart;
	}

	public void setDateStart(Date dateStart) {
		_dateStart = dateStart;
	}

	public Date getDateFinish() {
		return _dateFinish;
	}

	public void setDateFinish(Date dateFinish) {
		_dateFinish = dateFinish;
	}

	public long getBorrowerId() {
		return _borrowerId;
	}

	public void setBorrowerId(long borrowerId) {
		_borrowerId = borrowerId;
	}

	public long getBookId() {
		return _bookId;
	}

	public void setBookId(long bookId) {
		_bookId = bookId;
	}

	private String _uuid;
	private long _loanId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dateStart;
	private Date _dateFinish;
	private long _borrowerId;
	private long _bookId;
}
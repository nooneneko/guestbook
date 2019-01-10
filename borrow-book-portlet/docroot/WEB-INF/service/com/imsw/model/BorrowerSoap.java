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
 * This class is used by SOAP remote services, specifically {@link com.imsw.service.http.BorrowerServiceSoap}.
 *
 * @author User
 * @see com.imsw.service.http.BorrowerServiceSoap
 * @generated
 */
public class BorrowerSoap implements Serializable {
	public static BorrowerSoap toSoapModel(Borrower model) {
		BorrowerSoap soapModel = new BorrowerSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBorrowerId(model.getBorrowerId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setEmail(model.getEmail());
		soapModel.setPhoneNo(model.getPhoneNo());

		return soapModel;
	}

	public static BorrowerSoap[] toSoapModels(Borrower[] models) {
		BorrowerSoap[] soapModels = new BorrowerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BorrowerSoap[][] toSoapModels(Borrower[][] models) {
		BorrowerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BorrowerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BorrowerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BorrowerSoap[] toSoapModels(List<Borrower> models) {
		List<BorrowerSoap> soapModels = new ArrayList<BorrowerSoap>(models.size());

		for (Borrower model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BorrowerSoap[soapModels.size()]);
	}

	public BorrowerSoap() {
	}

	public long getPrimaryKey() {
		return _borrowerId;
	}

	public void setPrimaryKey(long pk) {
		setBorrowerId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBorrowerId() {
		return _borrowerId;
	}

	public void setBorrowerId(long borrowerId) {
		_borrowerId = borrowerId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getPhoneNo() {
		return _PhoneNo;
	}

	public void setPhoneNo(String PhoneNo) {
		_PhoneNo = PhoneNo;
	}

	private String _uuid;
	private long _borrowerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _address;
	private String _city;
	private String _email;
	private String _PhoneNo;
}
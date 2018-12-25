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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.docs.guestbook.service.http.GuestBookServiceSoap}.
 *
 * @author User
 * @see com.liferay.docs.guestbook.service.http.GuestBookServiceSoap
 * @generated
 */
public class GuestBookSoap implements Serializable {
	public static GuestBookSoap toSoapModel(GuestBook model) {
		GuestBookSoap soapModel = new GuestBookSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGuestBookId(model.getGuestBookId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static GuestBookSoap[] toSoapModels(GuestBook[] models) {
		GuestBookSoap[] soapModels = new GuestBookSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GuestBookSoap[][] toSoapModels(GuestBook[][] models) {
		GuestBookSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GuestBookSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GuestBookSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GuestBookSoap[] toSoapModels(List<GuestBook> models) {
		List<GuestBookSoap> soapModels = new ArrayList<GuestBookSoap>(models.size());

		for (GuestBook model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GuestBookSoap[soapModels.size()]);
	}

	public GuestBookSoap() {
	}

	public long getPrimaryKey() {
		return _guestBookId;
	}

	public void setPrimaryKey(long pk) {
		setGuestBookId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGuestBookId() {
		return _guestBookId;
	}

	public void setGuestBookId(long guestBookId) {
		_guestBookId = guestBookId;
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

	private String _uuid;
	private long _guestBookId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
}
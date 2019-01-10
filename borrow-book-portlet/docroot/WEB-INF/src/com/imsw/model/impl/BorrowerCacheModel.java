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

package com.imsw.model.impl;

import com.imsw.model.Borrower;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Borrower in entity cache.
 *
 * @author User
 * @see Borrower
 * @generated
 */
public class BorrowerCacheModel implements CacheModel<Borrower>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", borrowerId=");
		sb.append(borrowerId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", email=");
		sb.append(email);
		sb.append(", PhoneNo=");
		sb.append(PhoneNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Borrower toEntityModel() {
		BorrowerImpl borrowerImpl = new BorrowerImpl();

		if (uuid == null) {
			borrowerImpl.setUuid(StringPool.BLANK);
		}
		else {
			borrowerImpl.setUuid(uuid);
		}

		borrowerImpl.setBorrowerId(borrowerId);
		borrowerImpl.setGroupId(groupId);
		borrowerImpl.setCompanyId(companyId);
		borrowerImpl.setUserId(userId);

		if (userName == null) {
			borrowerImpl.setUserName(StringPool.BLANK);
		}
		else {
			borrowerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			borrowerImpl.setCreateDate(null);
		}
		else {
			borrowerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			borrowerImpl.setModifiedDate(null);
		}
		else {
			borrowerImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			borrowerImpl.setName(StringPool.BLANK);
		}
		else {
			borrowerImpl.setName(name);
		}

		if (address == null) {
			borrowerImpl.setAddress(StringPool.BLANK);
		}
		else {
			borrowerImpl.setAddress(address);
		}

		if (city == null) {
			borrowerImpl.setCity(StringPool.BLANK);
		}
		else {
			borrowerImpl.setCity(city);
		}

		if (email == null) {
			borrowerImpl.setEmail(StringPool.BLANK);
		}
		else {
			borrowerImpl.setEmail(email);
		}

		if (PhoneNo == null) {
			borrowerImpl.setPhoneNo(StringPool.BLANK);
		}
		else {
			borrowerImpl.setPhoneNo(PhoneNo);
		}

		borrowerImpl.resetOriginalValues();

		return borrowerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		borrowerId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		email = objectInput.readUTF();
		PhoneNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(borrowerId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (PhoneNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(PhoneNo);
		}
	}

	public String uuid;
	public long borrowerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String address;
	public String city;
	public String email;
	public String PhoneNo;
}
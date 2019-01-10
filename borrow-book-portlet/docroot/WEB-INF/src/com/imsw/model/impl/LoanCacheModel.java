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

import com.imsw.model.Loan;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Loan in entity cache.
 *
 * @author User
 * @see Loan
 * @generated
 */
public class LoanCacheModel implements CacheModel<Loan>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", loanId=");
		sb.append(loanId);
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
		sb.append(", dateStart=");
		sb.append(dateStart);
		sb.append(", dateFinish=");
		sb.append(dateFinish);
		sb.append(", borrowerId=");
		sb.append(borrowerId);
		sb.append(", bookId=");
		sb.append(bookId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Loan toEntityModel() {
		LoanImpl loanImpl = new LoanImpl();

		if (uuid == null) {
			loanImpl.setUuid(StringPool.BLANK);
		}
		else {
			loanImpl.setUuid(uuid);
		}

		loanImpl.setLoanId(loanId);
		loanImpl.setGroupId(groupId);
		loanImpl.setCompanyId(companyId);
		loanImpl.setUserId(userId);

		if (userName == null) {
			loanImpl.setUserName(StringPool.BLANK);
		}
		else {
			loanImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			loanImpl.setCreateDate(null);
		}
		else {
			loanImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			loanImpl.setModifiedDate(null);
		}
		else {
			loanImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dateStart == Long.MIN_VALUE) {
			loanImpl.setDateStart(null);
		}
		else {
			loanImpl.setDateStart(new Date(dateStart));
		}

		if (dateFinish == Long.MIN_VALUE) {
			loanImpl.setDateFinish(null);
		}
		else {
			loanImpl.setDateFinish(new Date(dateFinish));
		}

		loanImpl.setBorrowerId(borrowerId);
		loanImpl.setBookId(bookId);

		loanImpl.resetOriginalValues();

		return loanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		loanId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dateStart = objectInput.readLong();
		dateFinish = objectInput.readLong();
		borrowerId = objectInput.readLong();
		bookId = objectInput.readLong();
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

		objectOutput.writeLong(loanId);
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
		objectOutput.writeLong(dateStart);
		objectOutput.writeLong(dateFinish);
		objectOutput.writeLong(borrowerId);
		objectOutput.writeLong(bookId);
	}

	public String uuid;
	public long loanId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dateStart;
	public long dateFinish;
	public long borrowerId;
	public long bookId;
}
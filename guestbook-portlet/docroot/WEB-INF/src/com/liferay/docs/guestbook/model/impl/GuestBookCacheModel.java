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

package com.liferay.docs.guestbook.model.impl;

import com.liferay.docs.guestbook.model.GuestBook;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GuestBook in entity cache.
 *
 * @author User
 * @see GuestBook
 * @generated
 */
public class GuestBookCacheModel implements CacheModel<GuestBook>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", guestBookId=");
		sb.append(guestBookId);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GuestBook toEntityModel() {
		GuestBookImpl guestBookImpl = new GuestBookImpl();

		if (uuid == null) {
			guestBookImpl.setUuid(StringPool.BLANK);
		}
		else {
			guestBookImpl.setUuid(uuid);
		}

		guestBookImpl.setGuestBookId(guestBookId);
		guestBookImpl.setGroupId(groupId);
		guestBookImpl.setCompanyId(companyId);
		guestBookImpl.setUserId(userId);

		if (userName == null) {
			guestBookImpl.setUserName(StringPool.BLANK);
		}
		else {
			guestBookImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			guestBookImpl.setCreateDate(null);
		}
		else {
			guestBookImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			guestBookImpl.setModifiedDate(null);
		}
		else {
			guestBookImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			guestBookImpl.setName(StringPool.BLANK);
		}
		else {
			guestBookImpl.setName(name);
		}

		guestBookImpl.setStatus(status);
		guestBookImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			guestBookImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			guestBookImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			guestBookImpl.setStatusDate(null);
		}
		else {
			guestBookImpl.setStatusDate(new Date(statusDate));
		}

		guestBookImpl.resetOriginalValues();

		return guestBookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		guestBookId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
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

		objectOutput.writeLong(guestBookId);
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

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
	}

	public String uuid;
	public long guestBookId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
}
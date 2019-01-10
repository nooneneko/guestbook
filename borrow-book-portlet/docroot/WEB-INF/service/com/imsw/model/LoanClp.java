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

import com.imsw.service.ClpSerializer;
import com.imsw.service.LoanLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author User
 */
public class LoanClp extends BaseModelImpl<Loan> implements Loan {
	public LoanClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Loan.class;
	}

	@Override
	public String getModelClassName() {
		return Loan.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _loanId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLoanId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _loanId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("loanId", getLoanId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dateStart", getDateStart());
		attributes.put("dateFinish", getDateFinish());
		attributes.put("borrowerId", getBorrowerId());
		attributes.put("bookId", getBookId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long loanId = (Long)attributes.get("loanId");

		if (loanId != null) {
			setLoanId(loanId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Date dateStart = (Date)attributes.get("dateStart");

		if (dateStart != null) {
			setDateStart(dateStart);
		}

		Date dateFinish = (Date)attributes.get("dateFinish");

		if (dateFinish != null) {
			setDateFinish(dateFinish);
		}

		Long borrowerId = (Long)attributes.get("borrowerId");

		if (borrowerId != null) {
			setBorrowerId(borrowerId);
		}

		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_loanRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLoanId() {
		return _loanId;
	}

	@Override
	public void setLoanId(long loanId) {
		_loanId = loanId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setLoanId", long.class);

				method.invoke(_loanRemoteModel, loanId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_loanRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_loanRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_loanRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_loanRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_loanRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_loanRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateStart() {
		return _dateStart;
	}

	@Override
	public void setDateStart(Date dateStart) {
		_dateStart = dateStart;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setDateStart", Date.class);

				method.invoke(_loanRemoteModel, dateStart);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDateFinish() {
		return _dateFinish;
	}

	@Override
	public void setDateFinish(Date dateFinish) {
		_dateFinish = dateFinish;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setDateFinish", Date.class);

				method.invoke(_loanRemoteModel, dateFinish);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBorrowerId() {
		return _borrowerId;
	}

	@Override
	public void setBorrowerId(long borrowerId) {
		_borrowerId = borrowerId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setBorrowerId", long.class);

				method.invoke(_loanRemoteModel, borrowerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		_bookId = bookId;

		if (_loanRemoteModel != null) {
			try {
				Class<?> clazz = _loanRemoteModel.getClass();

				Method method = clazz.getMethod("setBookId", long.class);

				method.invoke(_loanRemoteModel, bookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Loan.class.getName()));
	}

	public BaseModel<?> getLoanRemoteModel() {
		return _loanRemoteModel;
	}

	public void setLoanRemoteModel(BaseModel<?> loanRemoteModel) {
		_loanRemoteModel = loanRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _loanRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_loanRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LoanLocalServiceUtil.addLoan(this);
		}
		else {
			LoanLocalServiceUtil.updateLoan(this);
		}
	}

	@Override
	public Loan toEscapedModel() {
		return (Loan)ProxyUtil.newProxyInstance(Loan.class.getClassLoader(),
			new Class[] { Loan.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LoanClp clone = new LoanClp();

		clone.setUuid(getUuid());
		clone.setLoanId(getLoanId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDateStart(getDateStart());
		clone.setDateFinish(getDateFinish());
		clone.setBorrowerId(getBorrowerId());
		clone.setBookId(getBookId());

		return clone;
	}

	@Override
	public int compareTo(Loan loan) {
		long primaryKey = loan.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LoanClp)) {
			return false;
		}

		LoanClp loan = (LoanClp)obj;

		long primaryKey = loan.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", loanId=");
		sb.append(getLoanId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dateStart=");
		sb.append(getDateStart());
		sb.append(", dateFinish=");
		sb.append(getDateFinish());
		sb.append(", borrowerId=");
		sb.append(getBorrowerId());
		sb.append(", bookId=");
		sb.append(getBookId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.imsw.model.Loan");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loanId</column-name><column-value><![CDATA[");
		sb.append(getLoanId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateStart</column-name><column-value><![CDATA[");
		sb.append(getDateStart());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateFinish</column-name><column-value><![CDATA[");
		sb.append(getDateFinish());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>borrowerId</column-name><column-value><![CDATA[");
		sb.append(getBorrowerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _loanId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dateStart;
	private Date _dateFinish;
	private long _borrowerId;
	private long _bookId;
	private BaseModel<?> _loanRemoteModel;
	private Class<?> _clpSerializerClass = com.imsw.service.ClpSerializer.class;
}
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
import com.imsw.model.BorrowerModel;
import com.imsw.model.BorrowerSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Borrower service. Represents a row in the &quot;BB_Borrower&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.imsw.model.BorrowerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BorrowerImpl}.
 * </p>
 *
 * @author User
 * @see BorrowerImpl
 * @see com.imsw.model.Borrower
 * @see com.imsw.model.BorrowerModel
 * @generated
 */
@JSON(strict = true)
public class BorrowerModelImpl extends BaseModelImpl<Borrower>
	implements BorrowerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a borrower model instance should use the {@link com.imsw.model.Borrower} interface instead.
	 */
	public static final String TABLE_NAME = "BB_Borrower";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "borrowerId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "address", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "PhoneNo", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table BB_Borrower (uuid_ VARCHAR(75) null,borrowerId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,address VARCHAR(75) null,city VARCHAR(75) null,email VARCHAR(75) null,PhoneNo VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table BB_Borrower";
	public static final String ORDER_BY_JPQL = " ORDER BY borrower.borrowerId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY BB_Borrower.borrowerId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.imsw.model.Borrower"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.imsw.model.Borrower"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.imsw.model.Borrower"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long UUID_COLUMN_BITMASK = 4L;
	public static long BORROWERID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Borrower toModel(BorrowerSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Borrower model = new BorrowerImpl();

		model.setUuid(soapModel.getUuid());
		model.setBorrowerId(soapModel.getBorrowerId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setAddress(soapModel.getAddress());
		model.setCity(soapModel.getCity());
		model.setEmail(soapModel.getEmail());
		model.setPhoneNo(soapModel.getPhoneNo());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Borrower> toModels(BorrowerSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Borrower> models = new ArrayList<Borrower>(soapModels.length);

		for (BorrowerSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.imsw.model.Borrower"));

	public BorrowerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _borrowerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBorrowerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _borrowerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Borrower.class;
	}

	@Override
	public String getModelClassName() {
		return Borrower.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("borrowerId", getBorrowerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("email", getEmail());
		attributes.put("PhoneNo", getPhoneNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long borrowerId = (Long)attributes.get("borrowerId");

		if (borrowerId != null) {
			setBorrowerId(borrowerId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String PhoneNo = (String)attributes.get("PhoneNo");

		if (PhoneNo != null) {
			setPhoneNo(PhoneNo);
		}
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getBorrowerId() {
		return _borrowerId;
	}

	@Override
	public void setBorrowerId(long borrowerId) {
		_borrowerId = borrowerId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getAddress() {
		if (_address == null) {
			return StringPool.BLANK;
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getPhoneNo() {
		if (_PhoneNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _PhoneNo;
		}
	}

	@Override
	public void setPhoneNo(String PhoneNo) {
		_PhoneNo = PhoneNo;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Borrower.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Borrower.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Borrower toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Borrower)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		BorrowerImpl borrowerImpl = new BorrowerImpl();

		borrowerImpl.setUuid(getUuid());
		borrowerImpl.setBorrowerId(getBorrowerId());
		borrowerImpl.setGroupId(getGroupId());
		borrowerImpl.setCompanyId(getCompanyId());
		borrowerImpl.setUserId(getUserId());
		borrowerImpl.setUserName(getUserName());
		borrowerImpl.setCreateDate(getCreateDate());
		borrowerImpl.setModifiedDate(getModifiedDate());
		borrowerImpl.setName(getName());
		borrowerImpl.setAddress(getAddress());
		borrowerImpl.setCity(getCity());
		borrowerImpl.setEmail(getEmail());
		borrowerImpl.setPhoneNo(getPhoneNo());

		borrowerImpl.resetOriginalValues();

		return borrowerImpl;
	}

	@Override
	public int compareTo(Borrower borrower) {
		long primaryKey = borrower.getPrimaryKey();

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

		if (!(obj instanceof Borrower)) {
			return false;
		}

		Borrower borrower = (Borrower)obj;

		long primaryKey = borrower.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		BorrowerModelImpl borrowerModelImpl = this;

		borrowerModelImpl._originalUuid = borrowerModelImpl._uuid;

		borrowerModelImpl._originalGroupId = borrowerModelImpl._groupId;

		borrowerModelImpl._setOriginalGroupId = false;

		borrowerModelImpl._originalCompanyId = borrowerModelImpl._companyId;

		borrowerModelImpl._setOriginalCompanyId = false;

		borrowerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Borrower> toCacheModel() {
		BorrowerCacheModel borrowerCacheModel = new BorrowerCacheModel();

		borrowerCacheModel.uuid = getUuid();

		String uuid = borrowerCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			borrowerCacheModel.uuid = null;
		}

		borrowerCacheModel.borrowerId = getBorrowerId();

		borrowerCacheModel.groupId = getGroupId();

		borrowerCacheModel.companyId = getCompanyId();

		borrowerCacheModel.userId = getUserId();

		borrowerCacheModel.userName = getUserName();

		String userName = borrowerCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			borrowerCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			borrowerCacheModel.createDate = createDate.getTime();
		}
		else {
			borrowerCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			borrowerCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			borrowerCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		borrowerCacheModel.name = getName();

		String name = borrowerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			borrowerCacheModel.name = null;
		}

		borrowerCacheModel.address = getAddress();

		String address = borrowerCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			borrowerCacheModel.address = null;
		}

		borrowerCacheModel.city = getCity();

		String city = borrowerCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			borrowerCacheModel.city = null;
		}

		borrowerCacheModel.email = getEmail();

		String email = borrowerCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			borrowerCacheModel.email = null;
		}

		borrowerCacheModel.PhoneNo = getPhoneNo();

		String PhoneNo = borrowerCacheModel.PhoneNo;

		if ((PhoneNo != null) && (PhoneNo.length() == 0)) {
			borrowerCacheModel.PhoneNo = null;
		}

		return borrowerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", borrowerId=");
		sb.append(getBorrowerId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", PhoneNo=");
		sb.append(getPhoneNo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.imsw.model.Borrower");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>borrowerId</column-name><column-value><![CDATA[");
		sb.append(getBorrowerId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PhoneNo</column-name><column-value><![CDATA[");
		sb.append(getPhoneNo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Borrower.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Borrower.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _borrowerId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _address;
	private String _city;
	private String _email;
	private String _PhoneNo;
	private long _columnBitmask;
	private Borrower _escapedModel;
}
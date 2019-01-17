/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.shopping.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ShoppingOrder service. Represents a row in the &quot;Shopping_ShoppingOrder&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.shopping.model.impl.ShoppingOrderModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.shopping.model.impl.ShoppingOrderImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a shopping order model instance should use the {@link ShoppingOrder} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrder
 * @see com.liferay.shopping.model.impl.ShoppingOrderImpl
 * @see com.liferay.shopping.model.impl.ShoppingOrderModelImpl
 * @generated
 */
public interface ShoppingOrderModel extends BaseModel<ShoppingOrder> {
	/**
	 * Gets the primary key of this shopping order.
	 *
	 * @return the primary key of this shopping order
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this shopping order
	 *
	 * @param pk the primary key of this shopping order
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the order id of this shopping order.
	 *
	 * @return the order id of this shopping order
	 */
	public long getOrderId();

	/**
	 * Sets the order id of this shopping order.
	 *
	 * @param orderId the order id of this shopping order
	 */
	public void setOrderId(long orderId);

	/**
	 * Gets the group id of this shopping order.
	 *
	 * @return the group id of this shopping order
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this shopping order.
	 *
	 * @param groupId the group id of this shopping order
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this shopping order.
	 *
	 * @return the company id of this shopping order
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this shopping order.
	 *
	 * @param companyId the company id of this shopping order
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this shopping order.
	 *
	 * @return the user id of this shopping order
	 */
	public long getUserId();

	/**
	 * Sets the user id of this shopping order.
	 *
	 * @param userId the user id of this shopping order
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this shopping order.
	 *
	 * @return the user uuid of this shopping order
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this shopping order.
	 *
	 * @param userUuid the user uuid of this shopping order
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this shopping order.
	 *
	 * @return the user name of this shopping order
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this shopping order.
	 *
	 * @param userName the user name of this shopping order
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this shopping order.
	 *
	 * @return the create date of this shopping order
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this shopping order.
	 *
	 * @param createDate the create date of this shopping order
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this shopping order.
	 *
	 * @return the modified date of this shopping order
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this shopping order.
	 *
	 * @param modifiedDate the modified date of this shopping order
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the number of this shopping order.
	 *
	 * @return the number of this shopping order
	 */
	@AutoEscape
	public String getNumber();

	/**
	 * Sets the number of this shopping order.
	 *
	 * @param number the number of this shopping order
	 */
	public void setNumber(String number);

	/**
	 * Gets the tax of this shopping order.
	 *
	 * @return the tax of this shopping order
	 */
	public double getTax();

	/**
	 * Sets the tax of this shopping order.
	 *
	 * @param tax the tax of this shopping order
	 */
	public void setTax(double tax);

	/**
	 * Gets the shipping of this shopping order.
	 *
	 * @return the shipping of this shopping order
	 */
	public double getShipping();

	/**
	 * Sets the shipping of this shopping order.
	 *
	 * @param shipping the shipping of this shopping order
	 */
	public void setShipping(double shipping);

	/**
	 * Gets the alt shipping of this shopping order.
	 *
	 * @return the alt shipping of this shopping order
	 */
	@AutoEscape
	public String getAltShipping();

	/**
	 * Sets the alt shipping of this shopping order.
	 *
	 * @param altShipping the alt shipping of this shopping order
	 */
	public void setAltShipping(String altShipping);

	/**
	 * Gets the requires shipping of this shopping order.
	 *
	 * @return the requires shipping of this shopping order
	 */
	public boolean getRequiresShipping();

	/**
	 * Determines if this shopping order is requires shipping.
	 *
	 * @return <code>true</code> if this shopping order is requires shipping; <code>false</code> otherwise
	 */
	public boolean isRequiresShipping();

	/**
	 * Sets whether this {$entity.humanName} is requires shipping.
	 *
	 * @param requiresShipping the requires shipping of this shopping order
	 */
	public void setRequiresShipping(boolean requiresShipping);

	/**
	 * Gets the insure of this shopping order.
	 *
	 * @return the insure of this shopping order
	 */
	public boolean getInsure();

	/**
	 * Determines if this shopping order is insure.
	 *
	 * @return <code>true</code> if this shopping order is insure; <code>false</code> otherwise
	 */
	public boolean isInsure();

	/**
	 * Sets whether this {$entity.humanName} is insure.
	 *
	 * @param insure the insure of this shopping order
	 */
	public void setInsure(boolean insure);

	/**
	 * Gets the insurance of this shopping order.
	 *
	 * @return the insurance of this shopping order
	 */
	public double getInsurance();

	/**
	 * Sets the insurance of this shopping order.
	 *
	 * @param insurance the insurance of this shopping order
	 */
	public void setInsurance(double insurance);

	/**
	 * Gets the coupon codes of this shopping order.
	 *
	 * @return the coupon codes of this shopping order
	 */
	@AutoEscape
	public String getCouponCodes();

	/**
	 * Sets the coupon codes of this shopping order.
	 *
	 * @param couponCodes the coupon codes of this shopping order
	 */
	public void setCouponCodes(String couponCodes);

	/**
	 * Gets the coupon discount of this shopping order.
	 *
	 * @return the coupon discount of this shopping order
	 */
	public double getCouponDiscount();

	/**
	 * Sets the coupon discount of this shopping order.
	 *
	 * @param couponDiscount the coupon discount of this shopping order
	 */
	public void setCouponDiscount(double couponDiscount);

	/**
	 * Gets the billing first name of this shopping order.
	 *
	 * @return the billing first name of this shopping order
	 */
	@AutoEscape
	public String getBillingFirstName();

	/**
	 * Sets the billing first name of this shopping order.
	 *
	 * @param billingFirstName the billing first name of this shopping order
	 */
	public void setBillingFirstName(String billingFirstName);

	/**
	 * Gets the billing last name of this shopping order.
	 *
	 * @return the billing last name of this shopping order
	 */
	@AutoEscape
	public String getBillingLastName();

	/**
	 * Sets the billing last name of this shopping order.
	 *
	 * @param billingLastName the billing last name of this shopping order
	 */
	public void setBillingLastName(String billingLastName);

	/**
	 * Gets the billing email address of this shopping order.
	 *
	 * @return the billing email address of this shopping order
	 */
	@AutoEscape
	public String getBillingEmailAddress();

	/**
	 * Sets the billing email address of this shopping order.
	 *
	 * @param billingEmailAddress the billing email address of this shopping order
	 */
	public void setBillingEmailAddress(String billingEmailAddress);

	/**
	 * Gets the billing company of this shopping order.
	 *
	 * @return the billing company of this shopping order
	 */
	@AutoEscape
	public String getBillingCompany();

	/**
	 * Sets the billing company of this shopping order.
	 *
	 * @param billingCompany the billing company of this shopping order
	 */
	public void setBillingCompany(String billingCompany);

	/**
	 * Gets the billing street of this shopping order.
	 *
	 * @return the billing street of this shopping order
	 */
	@AutoEscape
	public String getBillingStreet();

	/**
	 * Sets the billing street of this shopping order.
	 *
	 * @param billingStreet the billing street of this shopping order
	 */
	public void setBillingStreet(String billingStreet);

	/**
	 * Gets the billing city of this shopping order.
	 *
	 * @return the billing city of this shopping order
	 */
	@AutoEscape
	public String getBillingCity();

	/**
	 * Sets the billing city of this shopping order.
	 *
	 * @param billingCity the billing city of this shopping order
	 */
	public void setBillingCity(String billingCity);

	/**
	 * Gets the billing state of this shopping order.
	 *
	 * @return the billing state of this shopping order
	 */
	@AutoEscape
	public String getBillingState();

	/**
	 * Sets the billing state of this shopping order.
	 *
	 * @param billingState the billing state of this shopping order
	 */
	public void setBillingState(String billingState);

	/**
	 * Gets the billing zip of this shopping order.
	 *
	 * @return the billing zip of this shopping order
	 */
	@AutoEscape
	public String getBillingZip();

	/**
	 * Sets the billing zip of this shopping order.
	 *
	 * @param billingZip the billing zip of this shopping order
	 */
	public void setBillingZip(String billingZip);

	/**
	 * Gets the billing country of this shopping order.
	 *
	 * @return the billing country of this shopping order
	 */
	@AutoEscape
	public String getBillingCountry();

	/**
	 * Sets the billing country of this shopping order.
	 *
	 * @param billingCountry the billing country of this shopping order
	 */
	public void setBillingCountry(String billingCountry);

	/**
	 * Gets the billing phone of this shopping order.
	 *
	 * @return the billing phone of this shopping order
	 */
	@AutoEscape
	public String getBillingPhone();

	/**
	 * Sets the billing phone of this shopping order.
	 *
	 * @param billingPhone the billing phone of this shopping order
	 */
	public void setBillingPhone(String billingPhone);

	/**
	 * Gets the ship to billing of this shopping order.
	 *
	 * @return the ship to billing of this shopping order
	 */
	public boolean getShipToBilling();

	/**
	 * Determines if this shopping order is ship to billing.
	 *
	 * @return <code>true</code> if this shopping order is ship to billing; <code>false</code> otherwise
	 */
	public boolean isShipToBilling();

	/**
	 * Sets whether this {$entity.humanName} is ship to billing.
	 *
	 * @param shipToBilling the ship to billing of this shopping order
	 */
	public void setShipToBilling(boolean shipToBilling);

	/**
	 * Gets the shipping first name of this shopping order.
	 *
	 * @return the shipping first name of this shopping order
	 */
	@AutoEscape
	public String getShippingFirstName();

	/**
	 * Sets the shipping first name of this shopping order.
	 *
	 * @param shippingFirstName the shipping first name of this shopping order
	 */
	public void setShippingFirstName(String shippingFirstName);

	/**
	 * Gets the shipping last name of this shopping order.
	 *
	 * @return the shipping last name of this shopping order
	 */
	@AutoEscape
	public String getShippingLastName();

	/**
	 * Sets the shipping last name of this shopping order.
	 *
	 * @param shippingLastName the shipping last name of this shopping order
	 */
	public void setShippingLastName(String shippingLastName);

	/**
	 * Gets the shipping email address of this shopping order.
	 *
	 * @return the shipping email address of this shopping order
	 */
	@AutoEscape
	public String getShippingEmailAddress();

	/**
	 * Sets the shipping email address of this shopping order.
	 *
	 * @param shippingEmailAddress the shipping email address of this shopping order
	 */
	public void setShippingEmailAddress(String shippingEmailAddress);

	/**
	 * Gets the shipping company of this shopping order.
	 *
	 * @return the shipping company of this shopping order
	 */
	@AutoEscape
	public String getShippingCompany();

	/**
	 * Sets the shipping company of this shopping order.
	 *
	 * @param shippingCompany the shipping company of this shopping order
	 */
	public void setShippingCompany(String shippingCompany);

	/**
	 * Gets the shipping street of this shopping order.
	 *
	 * @return the shipping street of this shopping order
	 */
	@AutoEscape
	public String getShippingStreet();

	/**
	 * Sets the shipping street of this shopping order.
	 *
	 * @param shippingStreet the shipping street of this shopping order
	 */
	public void setShippingStreet(String shippingStreet);

	/**
	 * Gets the shipping city of this shopping order.
	 *
	 * @return the shipping city of this shopping order
	 */
	@AutoEscape
	public String getShippingCity();

	/**
	 * Sets the shipping city of this shopping order.
	 *
	 * @param shippingCity the shipping city of this shopping order
	 */
	public void setShippingCity(String shippingCity);

	/**
	 * Gets the shipping state of this shopping order.
	 *
	 * @return the shipping state of this shopping order
	 */
	@AutoEscape
	public String getShippingState();

	/**
	 * Sets the shipping state of this shopping order.
	 *
	 * @param shippingState the shipping state of this shopping order
	 */
	public void setShippingState(String shippingState);

	/**
	 * Gets the shipping zip of this shopping order.
	 *
	 * @return the shipping zip of this shopping order
	 */
	@AutoEscape
	public String getShippingZip();

	/**
	 * Sets the shipping zip of this shopping order.
	 *
	 * @param shippingZip the shipping zip of this shopping order
	 */
	public void setShippingZip(String shippingZip);

	/**
	 * Gets the shipping country of this shopping order.
	 *
	 * @return the shipping country of this shopping order
	 */
	@AutoEscape
	public String getShippingCountry();

	/**
	 * Sets the shipping country of this shopping order.
	 *
	 * @param shippingCountry the shipping country of this shopping order
	 */
	public void setShippingCountry(String shippingCountry);

	/**
	 * Gets the shipping phone of this shopping order.
	 *
	 * @return the shipping phone of this shopping order
	 */
	@AutoEscape
	public String getShippingPhone();

	/**
	 * Sets the shipping phone of this shopping order.
	 *
	 * @param shippingPhone the shipping phone of this shopping order
	 */
	public void setShippingPhone(String shippingPhone);

	/**
	 * Gets the cc name of this shopping order.
	 *
	 * @return the cc name of this shopping order
	 */
	@AutoEscape
	public String getCcName();

	/**
	 * Sets the cc name of this shopping order.
	 *
	 * @param ccName the cc name of this shopping order
	 */
	public void setCcName(String ccName);

	/**
	 * Gets the cc type of this shopping order.
	 *
	 * @return the cc type of this shopping order
	 */
	@AutoEscape
	public String getCcType();

	/**
	 * Sets the cc type of this shopping order.
	 *
	 * @param ccType the cc type of this shopping order
	 */
	public void setCcType(String ccType);

	/**
	 * Gets the cc number of this shopping order.
	 *
	 * @return the cc number of this shopping order
	 */
	@AutoEscape
	public String getCcNumber();

	/**
	 * Sets the cc number of this shopping order.
	 *
	 * @param ccNumber the cc number of this shopping order
	 */
	public void setCcNumber(String ccNumber);

	/**
	 * Gets the cc exp month of this shopping order.
	 *
	 * @return the cc exp month of this shopping order
	 */
	public int getCcExpMonth();

	/**
	 * Sets the cc exp month of this shopping order.
	 *
	 * @param ccExpMonth the cc exp month of this shopping order
	 */
	public void setCcExpMonth(int ccExpMonth);

	/**
	 * Gets the cc exp year of this shopping order.
	 *
	 * @return the cc exp year of this shopping order
	 */
	public int getCcExpYear();

	/**
	 * Sets the cc exp year of this shopping order.
	 *
	 * @param ccExpYear the cc exp year of this shopping order
	 */
	public void setCcExpYear(int ccExpYear);

	/**
	 * Gets the cc ver number of this shopping order.
	 *
	 * @return the cc ver number of this shopping order
	 */
	@AutoEscape
	public String getCcVerNumber();

	/**
	 * Sets the cc ver number of this shopping order.
	 *
	 * @param ccVerNumber the cc ver number of this shopping order
	 */
	public void setCcVerNumber(String ccVerNumber);

	/**
	 * Gets the comments of this shopping order.
	 *
	 * @return the comments of this shopping order
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this shopping order.
	 *
	 * @param comments the comments of this shopping order
	 */
	public void setComments(String comments);

	/**
	 * Gets the pp txn id of this shopping order.
	 *
	 * @return the pp txn id of this shopping order
	 */
	@AutoEscape
	public String getPpTxnId();

	/**
	 * Sets the pp txn id of this shopping order.
	 *
	 * @param ppTxnId the pp txn id of this shopping order
	 */
	public void setPpTxnId(String ppTxnId);

	/**
	 * Gets the pp payment status of this shopping order.
	 *
	 * @return the pp payment status of this shopping order
	 */
	@AutoEscape
	public String getPpPaymentStatus();

	/**
	 * Sets the pp payment status of this shopping order.
	 *
	 * @param ppPaymentStatus the pp payment status of this shopping order
	 */
	public void setPpPaymentStatus(String ppPaymentStatus);

	/**
	 * Gets the pp payment gross of this shopping order.
	 *
	 * @return the pp payment gross of this shopping order
	 */
	public double getPpPaymentGross();

	/**
	 * Sets the pp payment gross of this shopping order.
	 *
	 * @param ppPaymentGross the pp payment gross of this shopping order
	 */
	public void setPpPaymentGross(double ppPaymentGross);

	/**
	 * Gets the pp receiver email of this shopping order.
	 *
	 * @return the pp receiver email of this shopping order
	 */
	@AutoEscape
	public String getPpReceiverEmail();

	/**
	 * Sets the pp receiver email of this shopping order.
	 *
	 * @param ppReceiverEmail the pp receiver email of this shopping order
	 */
	public void setPpReceiverEmail(String ppReceiverEmail);

	/**
	 * Gets the pp payer email of this shopping order.
	 *
	 * @return the pp payer email of this shopping order
	 */
	@AutoEscape
	public String getPpPayerEmail();

	/**
	 * Sets the pp payer email of this shopping order.
	 *
	 * @param ppPayerEmail the pp payer email of this shopping order
	 */
	public void setPpPayerEmail(String ppPayerEmail);

	/**
	 * Gets the send order email of this shopping order.
	 *
	 * @return the send order email of this shopping order
	 */
	public boolean getSendOrderEmail();

	/**
	 * Determines if this shopping order is send order email.
	 *
	 * @return <code>true</code> if this shopping order is send order email; <code>false</code> otherwise
	 */
	public boolean isSendOrderEmail();

	/**
	 * Sets whether this {$entity.humanName} is send order email.
	 *
	 * @param sendOrderEmail the send order email of this shopping order
	 */
	public void setSendOrderEmail(boolean sendOrderEmail);

	/**
	 * Gets the send shipping email of this shopping order.
	 *
	 * @return the send shipping email of this shopping order
	 */
	public boolean getSendShippingEmail();

	/**
	 * Determines if this shopping order is send shipping email.
	 *
	 * @return <code>true</code> if this shopping order is send shipping email; <code>false</code> otherwise
	 */
	public boolean isSendShippingEmail();

	/**
	 * Sets whether this {$entity.humanName} is send shipping email.
	 *
	 * @param sendShippingEmail the send shipping email of this shopping order
	 */
	public void setSendShippingEmail(boolean sendShippingEmail);

	/**
	 * Gets a copy of this shopping order as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ShoppingOrder toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ShoppingOrder shoppingOrder);

	public int hashCode();

	public String toString();

	public String toXmlString();
}
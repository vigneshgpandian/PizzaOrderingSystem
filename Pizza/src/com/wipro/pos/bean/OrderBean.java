/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : OrderBean.java
 * Description   : This file is used to set/get the order details.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;


/**
 * This class is used to set/get the order details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_ORDER")
public class OrderBean {

	@Id
	@Column(name = "orderID", length = 20, nullable = false)
	private String orderID;
	@GeneratedValue
	@Column(name = "userID")
	private String userID;
	@GeneratedValue
	@Column(name = "storeID")
	private String storeID;
	@Column(name = "orderStatus", length = 20, nullable = false)
	private String orderStatus;
	@Column(name = "street", length = 20, nullable = false)
	private String street;
	@Column(name = "city", length = 20, nullable = false)
	private String city;
	@Column(name = "state", length = 20, nullable = false)
	private String state;
	@Column(name = "pincode", length = 20, nullable = false)
	private String pincode;
	@Column(name = "mobileNo", length = 20, nullable = false)
	@Pattern(regexp = "[0-9]+", message = "{pincode}")
	private String mobileNo;
	@GeneratedValue
	@Column(name = "cartID")
	private int cartID;
	/**
	 * @return the orderID
	 */
	public String getOrderID () {
		return orderID;
	}
	/**
	 * @param orderID
	 *            the orderID to set
	 */
	public void setOrderID (final String orderID) {
		this.orderID = orderID;
	}
	/**
	 * @return the userID
	 */
	public String getUserID () {
		return userID;
	}
	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID (final String userID) {
		this.userID = userID;
	}
	/**
	 * @return the storeID
	 */
	public String getStoreID () {
		return storeID;
	}
	/**
	 * @param storeID
	 *            the storeID to set
	 */
	public void setStoreID (final String storeID) {
		this.storeID = storeID;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus () {
		return orderStatus;
	}
	/**
	 * @param orderStatus
	 *            the orderStatus to set
	 */
	public void setOrderStatus (final String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the street
	 */
	public String getStreet () {
		return street;
	}
	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet (final String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity () {
		return city;
	}
	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity (final String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState () {
		return state;
	}
	/**
	 * @param state
	 *            the state to set
	 */
	public void setState (final String state) {
		this.state = state;
	}
	/**
	 * @return the pincode
	 */
	public String getPincode () {
		return pincode;
	}
	/**
	 * @param pincode
	 *            the pincode to set
	 */
	public void setPincode (final String pincode) {
		this.pincode = pincode;
	}
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo () {
		return mobileNo;
	}
	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo (final String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the orderDate
	 */
	/**
	 * @return the cartID
	 */
	public int getCartID () {
		return cartID;
	}
	/**
	 * @param cartID
	 *            the cartID to set
	 */
	public void setCartID (final int cartID) {
		this.cartID = cartID;
	}
	/**
	 * @return the totalPrice
	 */
	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
}

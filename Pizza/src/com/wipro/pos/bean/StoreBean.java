/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : StoreBean.java
 * Description   : This file is used to set/get the store details.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class is used to set/get the store details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_User_Store")
public class StoreBean {

	@Id
	@Column(name = "storeID", length = 6)
	private String storeID;
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	@Column(name = "street", length = 20, nullable = false)
	private String street;
	@Column(name = "mobileNo", length = 20, nullable = false)
	private String mobileNo;
	@Column(name = "city", length = 20, nullable = false)
	private String city;
	@Column(name = "state", length = 20, nullable = false)
	private String state;
	@Column(name = "pincode", length = 20, nullable = false)
	private String pincode;
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
	 * @return the name
	 */
	public String getName () {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName (final String name) {
		this.name = name;
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
}

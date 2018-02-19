/*
 * �Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : ProfileBean.java
 * Description   : This file is used to set/get the user profile details.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class is used to set/get the user details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version Feb 20, 2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_User_Profile")
public class ProfileBean {

	@Id
	@Column(name = "Userid")
	private String userID;
	@Column(name = "firstName", length = 20, nullable = false)
	private String firstName;
	@Column(name = "lastName", length = 20, nullable = false)
	private String lastName;
	@Column(name = "dateOfBirth", nullable = false)
	private Date dateOfBirth;
	@Column(name = "gender", length = 20, nullable = false)
	private String gender;
	@Column(name = "street", length = 30, nullable = false)
	private String street;
	@Column(name = "location", length = 20, nullable = false)
	private String location;
	@Column(name = "city", length = 20, nullable = false)
	private String city;
	@Column(name = "state", length = 20, nullable = false)
	private String state;
	@Column(name = "pincode", length = 20, nullable = false)
	private String pincode;
	@Column(name = "mobileNo", length = 20, nullable = false)
	private String mobileNo;
	@Column(name = "emailID", length = 20, nullable = false)
	private String emailID;
	@Column(name = "password", length = 20, nullable = false)
	private String password;
	private transient String ConformPassword;
	private transient String newpassword;
	/**
	 * @return the newpassword
	 */
	public String getNewpassword () {
		return newpassword;
	}
	/**
	 * @param newpassword
	 *            the newpassword to set
	 */
	public void setNewpassword (final String newpassword) {
		this.newpassword = newpassword;
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
	 * @return the firstName
	 */
	public String getFirstName () {
		return firstName;
	}
	/**
	 * @return the conformPassword
	 */
	public String getConformPassword () {
		return ConformPassword;
	}
	/**
	 * @param conformPassword
	 *            the conformPassword to set
	 */
	public void setConformPassword (final String conformPassword) {
		ConformPassword = conformPassword;
	}
	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName (final String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName () {
		return lastName;
	}
	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName (final String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth () {
		return dateOfBirth;
	}
	/**
	 *
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth (final Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the gender
	 */
	public String getGender () {
		return gender;
	}
	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender (final String gender) {
		this.gender = gender;
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
	 * @return the location
	 */
	public String getLocation () {
		return location;
	}
	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation (final String location) {
		this.location = location;
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
	 * @return the emailID
	 */
	public String getEmailID () {
		return emailID;
	}
	/**
	 * @param emailID
	 *            the emailID to set
	 */
	public void setEmailID (final String emailID) {
		this.emailID = emailID;
	}
	/**
	 * @return the password
	 */
	public String getPassword () {
		return password;
	}
	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword (final String password) {
		this.password = password;
	}
}

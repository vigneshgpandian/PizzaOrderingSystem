/*
 * © Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name      : CredentialsBean.java
 * Description    : This file is used to set/get the credentials details.
 * Version Number : 1.0
 * Created Date   : Feb 20, 2015
 */


package com.wipro.pos.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * This class is used to set/get the credentials details.
 *
 * @author VIGNESH
 * @author Nidhi Archana
 * @version 1.0, Feb 20, 2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_User_Credentials")
public class CredentialsBean {

	@Id
	@OneToMany
	@JoinColumn(name = "userID")
	private String userID;
	@Column(name = "Password", length = 20, nullable = false)
	private String password;
	@Column(name = "Usertype", length = 15, nullable = false)
	private String userType;
	@Column(name = "Loginstatus", length = 1, nullable = false)
	private int loginStatus;
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
	/**
	 * @return the userType
	 */
	public String getUserType () {
		return userType;
	}
	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType (final String userType) {
		this.userType = userType;
	}
	/**
	 * @return the loginStatus
	 */
	public int getLoginStatus () {
		return loginStatus;
	}
	/**
	 * @param loginStatus
	 *            the loginStatus to set
	 */
	public void setLoginStatus (final int loginStatus) {
		this.loginStatus = loginStatus;
	}
}

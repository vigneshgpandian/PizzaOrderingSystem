/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : Authentication.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.util;


import com.wipro.pos.bean.CredentialsBean;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface Authentication {

	/**
	 * This method is used to perform authentication.
	 *
	 * @param credentialsBean
	 *            to get the user credentials.
	 * @return boolean
	 */
	boolean authenticate (CredentialsBean credentials);
	/**
	 * This method is used to perform authorization.
	 *
	 * @param userId
	 *            to get user id.
	 * @return String
	 */
	String authorize (String userID);
	/**
	 * This method is used to change the login status.
	 *
	 * @param credentialsBean
	 *            to get user credentials.
	 * @param loginStatus
	 *            to get login status.
	 * @return boolean
	 */
	boolean changeLoginStatus (CredentialsBean credentials, int loginStatus);
}

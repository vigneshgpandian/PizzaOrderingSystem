/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : User.java
 * Description   : This file is used to perform user functionality.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.util;


import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.ProfileBean;


/**
 * This class is used to perform user functionality.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface User {

	/**
	 * This method is used to perform login functionality.
	 *
	 * @param credentials
	 *            to get the credentials detail.
	 * @return String as "A"/"C"/"FAIL"/“INVALID”
	 */
	String login (CredentialsBean credentials);
	/**
	 * This method is used to perform the logout functionality.
	 *
	 * @param userID
	 *            to get the UserID
	 * @return boolean value.
	 */
	boolean logout (String userID);
	/**
	 * This method is used to perform change password functionality.
	 *
	 * @param credentials
	 *            to get credential details.
	 * @param newPassword
	 *            to get new password.
	 * @return string as "SUCCESS"/“INVALID”
	 */
	String changePassword (CredentialsBean credentials, String newPassword);
	/**
	 * This method is used to perform the registration functionality.
	 *
	 * @param profile
	 *            to get user details.
	 * @return String as "FAIL"/"UserID"
	 */
	String register (ProfileBean profile);
}

/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : AuthenticationImpl.java
 * Description   : This file is used to perform administration functionality.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.util;


import com.wipro.pos.bean.CredentialsBean;


/**
 * This class is used to perform administration functionality.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public class AuthenticationImpl implements Authentication {

	@Override
	public boolean authenticate (final CredentialsBean credentials) {
		return false;
	}
	@Override
	public String authorize (final String userID) {
		return null;
	}
	@Override
	public boolean changeLoginStatus (final CredentialsBean credentials, final int loginStatus) {
		return false;
	}
}

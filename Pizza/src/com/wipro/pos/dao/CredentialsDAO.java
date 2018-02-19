/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CredentialsDAO.java
 * Description   : This file is used to perform CRUD operations on credentials.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.math.BigDecimal;
import java.util.List;

import com.wipro.pos.bean.CredentialsBean;


/**
 * This class is used to perform CRUD operations on credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface CredentialsDAO {

	/**
	 * This method is used to create credentials.
	 *
	 * @param cart
	 *            to get credentials details.
	 * @return String
	 */
	String createCredentials (CredentialsBean credentials);
	/**
	 * TThis method is used to delete a credentials.
	 *
	 * @param userID
	 *            to get user id.
	 * @return integer
	 */
	int deleteCredentials (List<String> userID);
	/**
	 * This method is used to update card details.
	 *
	 * @param cart
	 *            to get credentials details.
	 * @return boolean
	 */
	boolean updateCredentials (CredentialsBean credentials);
	/**
	 * This method is used to find the credentials by id.
	 *
	 * @param userID
	 *            to get user id.
	 * @return credentialsbean object
	 */
	CredentialsBean findByID (String userID);
	/**
	 * This method is used to get the List
	 *
	 * @return List
	 */
	List<CredentialsBean> findAll ();
	/**
	 * This method is used to update credentials
	 * 
	 * @param userID
	 *            is id of user
	 * @param loginStatus
	 *            is status of the user
	 * @return boolean
	 */
	boolean updateCredentials (String userID, int loginStatus);
	/**
	 * This method is used to get the id
	 * 
	 * @return bigdecimal
	 */
	BigDecimal findID ();
}

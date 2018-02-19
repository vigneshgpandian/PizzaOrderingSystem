/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : ProfileDAO.java
 * Description   : This file is used to perform CRUD operations on profile.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.util.List;

import com.wipro.pos.bean.ProfileBean;


/**
 * This class is used to perform CRUD operations on profile.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface ProfileDAO {

	/**
	 * This method is used to create Profile.
	 *
	 * @param Profile
	 *            to get Profile details.
	 * @return String
	 */
	String createProfile (ProfileBean profile);
	/**
	 * TThis method is used to delete a Profile.
	 *
	 * @param userID
	 *            to get user id.
	 * @return integer
	 */
	int deleteProfile (List<String> userID);
	/**
	 * This method is used to update card details.
	 *
	 * @param Profile
	 *            to get Order details.
	 * @return boolean
	 */
	boolean updateProfile (ProfileBean profile);
	/**
	 * This method is used to find the Profile by id.
	 *
	 * @param userID
	 *            to get user id.
	 * @return Profilebean object
	 */
	ProfileBean findByID (String userID);
	/**
	 * This method is used to get the List
	 *
	 * @return List
	 */
	List<ProfileBean> findAll ();
}

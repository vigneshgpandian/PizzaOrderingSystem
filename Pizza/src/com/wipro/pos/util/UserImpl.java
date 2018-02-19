/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : UserImpl.java
 * Description   : This file is used to perform user functionality.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.util;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.dao.CredentialsDAO;
import com.wipro.pos.dao.ProfileDAO;


/**
 * This class is used to perform user functionality.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Service
public class UserImpl implements User {

	@Autowired
	private CredentialsDAO credentialsDAO;
	@Autowired
	private ProfileDAO profileDAO;
	@Override
	@Transactional
	public String login (final CredentialsBean credentials) {
		String result = "INVALID";
		if (credentials instanceof CredentialsBean) {
			CredentialsBean credentialsDB = credentialsDAO.findByID(credentials.getUserID());
			if (credentialsDB instanceof CredentialsBean
					&& credentialsDB.getPassword().equals(credentials.getPassword())) {
				boolean flag = credentialsDAO.updateCredentials(credentials.getUserID(), 1);
				if (flag) {
					result = credentialsDB.getUserType();
				}
			}
		}
		return result;
	}
	@Override
	@Transactional
	public boolean logout (final String userID) {
		boolean result = false;
		if (userID instanceof String) {
			result = credentialsDAO.updateCredentials(userID, 0);
		}
		return result;
	}
	@Override
	@Transactional
	public String changePassword (final CredentialsBean credentials, final String newPassword) {
		String result = "INVALID";
		if (credentials instanceof CredentialsBean && newPassword instanceof String) {
			CredentialsBean credentialsDB = credentialsDAO.findByID(credentials.getUserID());
			if (credentialsDB instanceof CredentialsBean
					&& credentialsDB.getPassword().equals(credentials.getPassword())) {
				credentialsDB.setPassword(newPassword);
				boolean flag = credentialsDAO.updateCredentials(credentialsDB);
				if (flag) {
					result = "SUCCESS";
				}
			}
		}
		return result;
	}
	@Override
	@Transactional
	public String register (final ProfileBean profile) {
		CredentialsBean credentials = new CredentialsBean();
		String status = "INVALID";
		if (profile instanceof ProfileBean) {
			BigDecimal id = credentialsDAO.findID();
			if (profile.getFirstName() != null) {
				String userID = profile.getFirstName().substring(0, 2).toUpperCase();
				userID = userID + id;
				credentials.setUserID(userID);
				credentials.setUserType("C");
				credentials.setLoginStatus(0);
				credentials.setPassword(profile.getPassword());
				profile.setUserID(userID);
				// if (credentials instanceof CredentialsBean) {
				status = credentialsDAO.createCredentials(credentials);
			}
			if (status != null) {
				status = profileDAO.createProfile(profile);
			}
		}
		// }
		return status;
	}
}

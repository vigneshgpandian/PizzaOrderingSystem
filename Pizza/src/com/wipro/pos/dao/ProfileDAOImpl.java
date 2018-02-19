/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : ProfileDAOImpl.java
 * Description   : This file is used to perform CRUD operations on profile.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.pos.bean.ProfileBean;


/**
 * This class is used to perform CRUD operations on profile.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Repository
public class ProfileDAOImpl implements ProfileDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createProfile (final ProfileBean profile) {
		String key = "INVALID";
		try {
			key = (String) sessionFactory.getCurrentSession().save(profile);
		} catch (Exception e) {
			key = "INVALID";
		}
		return key;
	}
	@Override
	public int deleteProfile (final List<String> userID) {
		return 0;
	}
	@Override
	public boolean updateProfile (final ProfileBean profile) {
		return false;
	}
	@Override
	public ProfileBean findByID (final String userID) {
		return null;
	}
	@Override
	public List<ProfileBean> findAll () {
		return null;
	}
}

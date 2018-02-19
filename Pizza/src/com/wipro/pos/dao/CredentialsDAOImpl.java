/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CredentialsDAOImpl.java
 * Description   : This file is used to perform CRUD operations on credentials.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.pos.bean.CredentialsBean;


/**
 * This class is used to perform CRUD operations on credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Repository
public class CredentialsDAOImpl implements CredentialsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createCredentials (final CredentialsBean credentials) {
		String status = "INVALID";
		try {
			Session session = sessionFactory.getCurrentSession();
			status = (String) session.save(credentials);
		} catch (Exception e) {
			status = "INVALID";
		}
		return status;
	}
	@Override
	public int deleteCredentials (final List<String> userID) {
		return 0;
	}
	@Override
	public boolean updateCredentials (final CredentialsBean credentials) {
		boolean result = false;
		String newpassword = credentials.getPassword();
		String userID = credentials.getUserID();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update CredentialsBean set password=? where userID=?");
		query.setParameter(0, newpassword);
		query.setParameter(1, userID);
		int status = query.executeUpdate();
		if (status != 0) {
			result = true;
		}
		return result;
	}
	@Override
	public CredentialsBean findByID (final String userID) {
		Session session = sessionFactory.getCurrentSession();
		CredentialsBean credentials = null;
		if (userID instanceof String) {
			credentials = (CredentialsBean) session.get(CredentialsBean.class, userID);
		}
		return credentials;
	}
	@Override
	public List<CredentialsBean> findAll () {
		return null;
	}
	@Override
	public boolean updateCredentials (final String userID, final int loginStatus) {
		boolean result = false;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update CredentialsBean set loginStatus=? where userID=?");
		query.setParameter(0, loginStatus);
		query.setParameter(1, userID);
		int status = query.executeUpdate();
		if (status != 0) {
			result = true;
		}
		return result;
	}
	@Override
	public BigDecimal findID () {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select POS_SEQ_USERID.nextval from dual");
		BigDecimal id = (BigDecimal) query.uniqueResult();
		return id;
	}
}

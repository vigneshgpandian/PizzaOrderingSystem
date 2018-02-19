/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : StoreDAOImpl.java
 * Description   : This file is used to perform CRUD operations on store.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.pos.bean.StoreBean;


/**
 * This class is used to perform CRUD operations on store.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Repository
public class StoreDAOImpl implements StoreDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createStore (final StoreBean store) {
		String key = "FAIL";
		try {
			key = (String) sessionFactory.getCurrentSession().save(store);
			key = "SUCCESS";
		} catch (Exception e) {
			key = "FAIL";
		}
		return key;
	}
	@Override
	public int deleteStore (final ArrayList<String> storeId) {
		String store = storeId.get(0);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete StoreBean where storeID = :storeID");
		query.setParameter("storeID", store);
		int result = query.executeUpdate();
		return result;
	}
	@Override
	public boolean updateStore (final StoreBean store) {
		Session session = sessionFactory.getCurrentSession();
		session.update(store);
		return true;
	}
	@Override
	public StoreBean findByID (final String storeID) {
		Session session = sessionFactory.getCurrentSession();
		StoreBean store = null;
		if (storeID instanceof String) {
			store = (StoreBean) session.get(StoreBean.class, storeID);
		}
		return store;
	}
	@Override
	public List<StoreBean> findAll () {
		List<StoreBean> list = sessionFactory.getCurrentSession().createQuery("from StoreBean").list();
		return list;
	}
	@Override
	public BigDecimal findID () {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select POS_SEQ_STOREID.nextval from dual");
		BigDecimal id = (BigDecimal) query.uniqueResult();
		return id;
	}
}

/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CartDAOImpl.java
 * Description   : This file is used to perform CRUD operations on cart.
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

import com.wipro.pos.bean.CartBean;


/**
 * This class is used to perform CRUD operations on cart.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Repository
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createCart (final CartBean cart) {
		String key = "ccv";
		/* try { */
		sessionFactory.getCurrentSession().save(cart);
		/*
		 * key = "SUCCESS"; System.out.println(key); } catch (Exception e) { key = "FAIL"; }
		 */
		return key;
	}
	@Override
	public int deleteCart (final List<String> cartID) {
		Session session = sessionFactory.getCurrentSession();
		int cart = Integer.parseInt(cartID.get(0));
		Query query = session.createQuery("delete CartBean where cartID = :cartID");
		query.setParameter("cartID", cart);
		int result = query.executeUpdate();
		return result;
	}
	@Override
	public boolean updateCart (final CartBean cart) {
		Session session = sessionFactory.getCurrentSession();
		session.update(cart);
		return false;
	}
	@Override
	public List<CartBean> findByID (final String userID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CartBean where userID = :id");
		query.setParameter("id", userID);
		List<CartBean> list = new ArrayList<CartBean>();
		list = query.list();
		return list;
	}
	@Override
	public List<CartBean> findAll () {
		return null;
	}
	@Override
	public int findID () {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select POS_SEQ_CARTID.nextval from dual");
		BigDecimal bigid = (BigDecimal) query.uniqueResult();
		int id = bigid.intValue();
		return id;
	}
}

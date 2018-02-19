/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : OrderDAOImpl.java
 * Description   : This file is used to perform CRUD operations on order.
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

import com.wipro.pos.bean.OrderBean;


/**
 * This class is used to perform CRUD operations on order detials.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createOrder (final OrderBean order) {
		sessionFactory.getCurrentSession().save(order);
		return null;
	}
	@Override
	public int deleteOrder (final List<String> orderID) {
		return 0;
	}
	@Override
	public boolean updateOrder (final OrderBean order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
		return false;
	}
	@Override
	public List<OrderBean> findByID (final String userID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from OrderBean where userID = :id");
		query.setParameter("id", userID);
		List<OrderBean> list = new ArrayList<OrderBean>();
		list = query.list();
		return list;
	}
	@Override
	public List<OrderBean> findAll () {
		return null;
	}
	@Override
	public BigDecimal findID () {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select POS_SEQ_ORDERID.nextval from dual");
		BigDecimal id = (BigDecimal) query.uniqueResult();
		return id;
	}
}

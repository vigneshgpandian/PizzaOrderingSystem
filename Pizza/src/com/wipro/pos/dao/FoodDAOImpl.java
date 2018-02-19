/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : FoodDAOImpl.java
 * Description   : This file is used to perform CRUD operations on food.
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

import com.wipro.pos.bean.FoodBean;


/**
 * This class is used to perform CRUD operations on food.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Repository
public class FoodDAOImpl implements FoodDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public String createFood (final FoodBean food) {
		String key = "FAIL";
		try {
			key = (String) sessionFactory.getCurrentSession().save(food);
			key = "SUCCESS";
		} catch (Exception e) {
			key = "FAIL";
		}
		return key;
	}
	@Override
	public int deleteFood (final List<String> foodID) {
		String food = foodID.get(0);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete FoodBean where foodID = :foodID");
		query.setParameter("foodID", food);
		int result = query.executeUpdate();
		return 0;
	}
	@Override
	public boolean updateFood (final FoodBean food) {
		Session session = sessionFactory.getCurrentSession();
		session.update(food);
		return true;
	}
	@Override
	public FoodBean findByID (final String foodID) {
		Session session = sessionFactory.getCurrentSession();
		FoodBean food = null;
		if (foodID instanceof String) {
			food = (FoodBean) session.get(FoodBean.class, foodID);
		}
		return food;
	}
	@Override
	public List<FoodBean> findAll () {
		List<FoodBean> list = sessionFactory.getCurrentSession().createQuery("from FoodBean").list();
		return list;
	}
	@Override
	public BigDecimal findID () {
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select POS_SEQ_FOODID.nextval from dual");
		BigDecimal id = (BigDecimal) query.uniqueResult();
		return id;
	}
}

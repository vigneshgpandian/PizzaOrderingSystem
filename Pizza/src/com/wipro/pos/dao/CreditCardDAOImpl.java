/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CreditCardDAOImpl.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Mar 11, 2015
 */


package com.wipro.pos.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wipro.pos.bean.CreditCardBean;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Mar 11, 2015
 * @since 1.0
 */
@Repository
public class CreditCardDAOImpl implements CreditCardDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public CreditCardBean findByID (final String cardNumber) {
		Session session = sessionFactory.getCurrentSession();
		CreditCardBean card = null;
		try {
			card = (CreditCardBean) session.get(CreditCardBean.class, cardNumber);
		} catch (Exception e) {
			card.setBalance(0);
		}
		return card;
	}
	@Override
	public boolean updateCreditCard (final CreditCardBean creditcard) {
		Session session = sessionFactory.getCurrentSession();
		session.update(creditcard);
		return false;
	}
}

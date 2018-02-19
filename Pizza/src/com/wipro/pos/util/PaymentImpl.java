/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : PaymentImpl.java
 * Description   : This file is used to perform payment functionality.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.util;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.CreditCardBean;
import com.wipro.pos.dao.CreditCardDAO;
import com.wipro.pos.service.Customer;


/**
 * This class is used to perform payment functionality.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Service
public class PaymentImpl implements Payment {

	@Autowired
	private CreditCardDAO creditcardDAO;
	@Autowired
	private Customer customer;
	@Autowired
	private CreditCardDAO cardDAO;
	@Override
	@Transactional
	public boolean findByCardNumber (final String userID, final String cardnumber) {
		CreditCardBean card = new CreditCardBean();
		boolean result = false;
		card = creditcardDAO.findByID(cardnumber);
		List<CartBean> list = new ArrayList<CartBean>();
		list = customer.viewCart(userID);
		Iterator<CartBean> itr = list.iterator();
		double total = 0;
		while (itr.hasNext()) {
			total = total + itr.next().getCost();
		}
		System.out.println(card.getBalance());
		if (card.getBalance() >= total) {
			result = true;
		}
		return result;
	}
	@Override
	@Transactional
	public String process (final CreditCardBean card) {
		List<CartBean> list = new ArrayList<CartBean>();
		list = customer.viewCart(card.getUserID());
		Iterator<CartBean> itr = list.iterator();
		double total = 0;
		while (itr.hasNext()) {
			total = total + itr.next().getCost();
		}
		CreditCardBean cardbean = new CreditCardBean();
		cardbean = cardDAO.findByID(card.getCreditcardNo());
		double bal2 = cardbean.getBalance();
		double bal = bal2 - total;
		cardbean.setBalance(bal);
		cardbean.setUserID(card.getUserID());
		creditcardDAO.updateCreditCard(cardbean);
		return null;
	}
	@Override
	@Transactional
	public String cashBack (final CreditCardBean card) {
		List<CartBean> list = new ArrayList<CartBean>();
		list = customer.viewCart(card.getUserID());
		Iterator<CartBean> itr = list.iterator();
		double total = 0;
		while (itr.hasNext()) {
			total = total + itr.next().getCost();
		}
		CreditCardBean cardbean = new CreditCardBean();
		cardbean = cardDAO.findByID(card.getCreditcardNo());
		double bal2 = cardbean.getBalance();
		double bal = bal2 - total;
		creditcardDAO.updateCreditCard(cardbean);
		return null;
	}
}

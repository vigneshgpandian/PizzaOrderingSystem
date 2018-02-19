/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CustomerImpl.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.CartDAO;
import com.wipro.pos.dao.FoodDAO;
import com.wipro.pos.dao.OrderDAO;
import com.wipro.pos.dao.StoreDAO;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Service
public class CustomerImpl implements Customer {

	@Autowired
	private StoreDAO storeDAO;
	@Autowired
	private FoodDAO foodDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Override
	@Transactional
	public int addToCart (final CartBean cart) {
		int result = 0;
		if (cart instanceof CartBean && cart.getType() != null) {
			int cartid = cartDAO.findID();
			double foodprice = foodDAO.findByID(cart.getFoodID()).getPrice();
			cart.setCost(cart.getQuantity() * foodprice);
			cart.setCartID(cartid);
			cartDAO.createCart(cart);
			result = 1;
		}
		return result;
	}
	@Override
	@Transactional
	public boolean modifyCart (final CartBean cart) {
		boolean result = false;
		if (cart instanceof CartBean && cart.getType() != null) {
			double foodprice = foodDAO.findByID(cart.getFoodID()).getPrice();
			cart.setCost(cart.getQuantity() * foodprice);
			cartDAO.updateCart(cart);
			result = true;
		}
		return result;
	}
	@Override
	@Transactional
	public String confirmOrder (final OrderBean order, final List<CartBean> cart) {
		String result = "INVALID";
		if (order instanceof OrderBean && order.getUserID() != null) {
			BigDecimal bigid = orderDAO.findID();
			int id = bigid.intValue();
			String iD = Integer.toString(id);
			order.setOrderID(iD);
			order.setCartID(cart.get(0).getCartID());
			order.setOrderStatus("Confirmed");
			orderDAO.createOrder(order);
			result = "SUCCESS";
		}
		return result;
	}
	@Override
	@Transactional
	public String cancelOrder (final OrderBean order) {
		String result = "INVALID";
		if (order instanceof OrderBean && order.getUserID() != null) {
			order.setOrderStatus("CANCELLED");
			orderDAO.updateOrder(order);
			result = "SUCCESS";
		}
		return result;
	}
	@Override
	@Transactional
	public List<StoreBean> viewStore (final String city) {
		List<StoreBean> list = new ArrayList<StoreBean>();
		list = storeDAO.findAll();
		List<StoreBean> finalList = new ArrayList<StoreBean>();
		for (StoreBean obj : list) {
			if (obj.getCity().equals(city)) {
				finalList.add(obj);
			}
		}
		return finalList;
	}
	@Override
	@Transactional
	public List<CartBean> viewCart (final String userID) {
		List<CartBean> list = new ArrayList<CartBean>();
		list = cartDAO.findByID(userID);
		return list;
	}
	@Override
	@Transactional
	public List<OrderBean> viewOrder (final String userID) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		list = orderDAO.findByID(userID);
		return list;
	}
	@Override
	@Transactional
	public int removeCart (final String cartID) {
		int result = 0;
		if (cartID instanceof String) {
			List<String> list = new ArrayList<String>();
			list.add(cartID);
			cartDAO.deleteCart(list);
			result = 1;
		}
		return result;
	}
}

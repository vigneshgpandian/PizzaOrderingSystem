/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : OrderDAO.java
 * Description   : This file is used to perform CRUD operations on order.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.math.BigDecimal;
import java.util.List;

import com.wipro.pos.bean.OrderBean;


/**
 * This class is used to perform CRUD operations on order.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface OrderDAO {

	/**
	 * This method is used to create Order.
	 *
	 * @param Order
	 *            to get Order details.
	 * @return String
	 */
	String createOrder (OrderBean order);
	/**
	 * TThis method is used to delete a Order.
	 *
	 * @param orderID
	 *            to get order ID .
	 * @return integer
	 */
	int deleteOrder (List<String> orderID);
	/**
	 * This method is used to update card details.
	 *
	 * @param Order
	 *            to get Order details.
	 * @return boolean
	 */
	boolean updateOrder (OrderBean order);
	/**
	 * This method is used to find the Order by id.
	 *
	 * @param orderID
	 *            to get order ID .
	 * @return Orderbean object
	 */
	List<OrderBean> findByID (String orderID);
	/**
	 * This method is used to get the List
	 *
	 * @return List
	 */
	List<OrderBean> findAll ();
	/**
	 * This method is used to find id
	 * 
	 * @return big decimal
	 */
	BigDecimal findID ();
}

/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : Customer.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.service;


import java.util.List;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.bean.StoreBean;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface Customer {

	/**
	 * This method is used to add item to the card.
	 *
	 * @param cartBean
	 *            is the object of CartBean class.
	 * @return integer
	 */
	int addToCart (CartBean cart);
	/**
	 * This method is used to make modifications to the card.
	 *
	 * @param cartBean
	 *            is the object of CartBean class.
	 * @return boolean
	 */
	boolean modifyCart (CartBean cart);
	/**
	 * This method is used to conform the order.
	 *
	 * @param orderBean
	 *            is to get the details of the order.
	 * @param cartbean
	 *            is to get the details of the cart.
	 * @return String
	 */
	String confirmOrder (OrderBean order, List<CartBean> cart);
	/**
	 * This method is used to cancel a order.
	 *
	 * @param orderId
	 *            is to get the details of the order.
	 * @return String
	 */
	String cancelOrder (OrderBean order);
	/**
	 * This method is to display the details of the available store in a city.
	 *
	 * @param city
	 *            get the name of the city.
	 * @return List
	 */
	List<StoreBean> viewStore (String city);
	/**
	 * This method is used to view the items in the cart.
	 *
	 * @param userid
	 *            is to get the UserID.
	 * @return List
	 */
	List<CartBean> viewCart (String userID);
	/**
	 * This method is to view the order summary.
	 *
	 * @return List
	 */
	List<OrderBean> viewOrder (String userID);
	/**
	 * This method is used to remove the cart
	 * 
	 * @param cartID
	 *            id id of the cart
	 * @return int
	 */
	int removeCart (String cartID);
}

/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CartDAO.java
 * Description   : This file is used to perform CRUD operations on cart.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.util.List;

import com.wipro.pos.bean.CartBean;


/**
 * This class is used to to perform CRUD operations on cart.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface CartDAO {

	/**
	 * This method is used to create cart.
	 *
	 * @param cart
	 *            to get cart details.
	 * @return String
	 */
	String createCart (CartBean cart);
	/**
	 * TThis method is used to delete a cart.
	 *
	 * @param userID
	 *            to get user id.
	 * @return integer
	 */
	int deleteCart (List<String> cartID);
	/**
	 * This method is used to update card details.
	 *
	 * @param cart
	 *            to get cart details.
	 * @return boolean
	 */
	boolean updateCart (CartBean cart);
	/**
	 * This method is used to find the cart by id.
	 *
	 * @param userID
	 *            to get user id.
	 * @return cartbean object
	 */
	List<CartBean> findByID (String userID);
	/**
	 * This method is used to get the List
	 *
	 * @return List
	 */
	List<CartBean> findAll ();
	/**
	 * This method is used to find the id
	 *
	 * @return int
	 */
	int findID ();
}

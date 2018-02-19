/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : FoodDAO.java
 * Description   : This file is used to perform CRUD operations on food.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.math.BigDecimal;
import java.util.List;

import com.wipro.pos.bean.FoodBean;


/**
 * This class is used to perform CRUD operations on food.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface FoodDAO {

	/**
	 * This method is used to create food.
	 *
	 * @param food
	 *            to get food details.
	 * @return String
	 */
	String createFood (FoodBean food);
	/**
	 * TThis method is used to delete a food.
	 *
	 * @param foodID
	 *            to get food ID .
	 * @return integer
	 */
	int deleteFood (List<String> foodID);
	/**
	 * This method is used to update card details.
	 *
	 * @param food
	 *            to get food details.
	 * @return boolean
	 */
	boolean updateFood (FoodBean food);
	/**
	 * This method is used to find the food by id.
	 *
	 * @param foodID
	 *            to get food ID .
	 * @return foodbean object
	 */
	FoodBean findByID (String foodID);
	/**
	 * This method is used to get the List of food by id
	 *
	 * @return List
	 */
	List<FoodBean> findAll ();
	/**
	 * This method is used to find id
	 * 
	 * @return big decimal
	 */
	BigDecimal findID ();
}

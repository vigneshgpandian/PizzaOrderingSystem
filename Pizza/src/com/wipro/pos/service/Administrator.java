/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : Administrator.java
 * Description   : This file is used to perform administration functionality .
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.service;


import java.util.ArrayList;
import java.util.List;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.StoreBean;


/**
 * This class is used to perform administration functionality .
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface Administrator {

	/**
	 * This method is used to a new store.
	 *
	 * @param storebean
	 *            to get the store details.
	 * @return String as "SUCCESS"/"FAIL"/“ERROR”
	 */
	String addStore (StoreBean store);
	/**
	 * This method is used to modify the existing store details.
	 *
	 * @param storebean
	 *            is used to get the store details.
	 * @return boolean value.
	 */
	boolean modifyStore (StoreBean store);
	/**
	 * This method is to remove a existing store.
	 *
	 * @param storeId
	 *            is the list of available store ID.
	 * @return integer value
	 */
	int removeStore (final ArrayList<String> storeId);
	/**
	 * This method display's the details of a particular store.
	 *
	 * @param storeId
	 *            is the store ID.
	 * @return object of StoreBean
	 */
	StoreBean viewStore (String storeID);
	/**
	 * This method is to display the details of all the available stores.
	 *
	 * @return List
	 */
	List<StoreBean> viewAllStore ();
	/**
	 * This method is used to add a food item.
	 *
	 * @param foodbean
	 *            is a object of FoodBean class.
	 * @return String
	 */
	String addFood (FoodBean food);
	/**
	 * This method is to modify the details of the existing food items.
	 *
	 * @param foodbean
	 *            is a object of FoodBean class.
	 * @return boolean
	 */
	boolean modifyFood (FoodBean food);
	/**
	 * This method is used to remove a existing food item.
	 *
	 * @param storeId
	 *            is the ID of the store.
	 * @param foodId
	 *            is the ID of the food item.
	 * @return boolean
	 */
	boolean removeFood (String foodID);
	/**
	 * This method is used to display the details of a perticular existing food item.
	 *
	 * @param foodId
	 *            is the ID of the food item.
	 * @return object of FoodBean class.
	 */
	FoodBean viewFood (String foodID);
	/**
	 * This method is to display all the existing food items.
	 *
	 * @param storeId
	 *            is the ID of the store.
	 * @return List
	 */
	List<FoodBean> viewAllFood ();
	/**
	 * This method is to change the status of the order.
	 *
	 * @param orderId
	 *            is the ID of the order to be changed.
	 * @return String as "SUCCESS"/"FAIL"
	 */
	String changeOrderStatus (String orderID);
}

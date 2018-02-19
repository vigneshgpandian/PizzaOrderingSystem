/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : StoreDAO.java
 * Description   : This file is used to perform CRUD operations on store.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wipro.pos.bean.StoreBean;


/**
 * This class is used to perform CRUD operations on store.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface StoreDAO {

	/**
	 * This method is used to create Store.
	 *
	 * @param Store
	 *            to get Store details.
	 * @return String
	 */
	String createStore (StoreBean store);
	/**
	 * TThis method is used to delete a Store.
	 *
	 * @param storeId
	 *            to get store ID.
	 * @return integer
	 */
	int deleteStore (ArrayList<String> storeId);
	/**
	 * This method is used to update card details.
	 *
	 * @param Store
	 *            to get Order details.
	 * @return boolean
	 */
	boolean updateStore (StoreBean store);
	/**
	 * This method is used to find the Store by id.
	 *
	 * @param storeID
	 *            to get store ID.
	 * @return Storebean object
	 */
	StoreBean findByID (String storeID);
	/**
	 * This method is used to get the List
	 *
	 * @return List
	 */
	List<StoreBean> findAll ();
	/**
	 * This method is used to find id
	 * 
	 * @return big decimal
	 */
	BigDecimal findID ();
}

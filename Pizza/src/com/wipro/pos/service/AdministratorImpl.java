/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : AdministratorImpl.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.FoodDAO;
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
public class AdministratorImpl implements Administrator {

	@Autowired
	private StoreDAO storeDAO;
	@Autowired
	private FoodDAO foodDAO;
	@Override
	@Transactional
	public String addStore (final StoreBean store) {
		String result = "FAIL";
		if (store instanceof StoreBean && store.getCity() != null) {
			String storeID = store.getName().substring(0, 2).toUpperCase();
			storeID = storeID + storeDAO.findID();
			store.setStoreID(storeID);
			result = storeDAO.createStore(store);
		}
		return result;
	}
	@Override
	@Transactional
	public boolean modifyStore (final StoreBean store) {
		boolean result = false;
		if (store instanceof StoreBean) {
			result = storeDAO.updateStore(store);
			result = true;
		}
		return result;
	}
	@Override
	@Transactional
	public int removeStore (final ArrayList<String> storeId) {
		int result = 0;
		if (storeId.get(0) != null) {
			storeDAO.deleteStore(storeId);
			result = 1;
		}
		return result;
	}
	@Override
	@Transactional
	public StoreBean viewStore (final String storeID) {
		StoreBean store = new StoreBean();
		if (storeID instanceof String) {
			store = storeDAO.findByID(storeID);
		}
		return store;
	}
	@Override
	@Transactional
	public List<StoreBean> viewAllStore () {
		return storeDAO.findAll();
	}
	@Override
	@Transactional
	public String addFood (final FoodBean food) {
		String result = "FAIL";
		if (food instanceof FoodBean && food.getName() != null) {
			String foodID = food.getName().substring(0, 2).toUpperCase();
			foodID = foodID + foodDAO.findID();
			food.setFoodID(foodID);
			result = foodDAO.createFood(food);
		}
		return result;
	}
	@Override
	@Transactional
	public boolean modifyFood (final FoodBean food) {
		boolean result = false;
		if (food instanceof FoodBean && food.getFoodID() != null) {
			result = foodDAO.updateFood(food);
		}
		return result;
	}
	@Override
	@Transactional
	public boolean removeFood (final String foodID) {
		boolean result = false;
		if (foodID instanceof String && foodID != null) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(foodID);
			foodDAO.deleteFood(list);
			result = true;
		}
		return result;
	}
	@Override
	@Transactional
	public FoodBean viewFood (final String foodID) {
		FoodBean food = new FoodBean();
		// if (storeID instanceof String) {
		food = foodDAO.findByID(foodID);
		// }
		return food;
	}
	@Override
	@Transactional
	public List<FoodBean> viewAllFood () {
		return foodDAO.findAll();
	}
	@Override
	@Transactional
	public String changeOrderStatus (final String orderID) {
		return null;
	}
}

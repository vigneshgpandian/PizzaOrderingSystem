/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : AdministratorImplTest.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 26, 2015
 */


package com.wipro.pos.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 26, 2015
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/Dispatcher-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class AdministratorImplTest {

	@Autowired
	private Administrator administrator;
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#addStore(com.wipro.pos.bean.StoreBean)}.
	 */
	@Test
	public void testAddStore () {
		StoreBean store = new StoreBean();
		// TestCase-1 for null input
		String actual = administrator.addStore(null);
		assertEquals("FAIL", actual);
		// TestCase-2 for empty object
		actual = administrator.addStore(store);
		assertEquals("FAIL", actual);
		// testcase-3 for perfect data
		store.setCity("chennai");
		store.setMobileNo("1234567890");
		store.setName("vignesh");
		store.setPincode("111111");
		store.setState("tamilnadu");
		store.setStoreID("PI1102");
		store.setStreet("kolathur");
		actual = administrator.addStore(store);
		assertEquals("SUCCESS", actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#modifyStore(com.wipro.pos.bean.StoreBean)}.
	 */
	@Test
	public void testModifyStore () {
		// testcase-1 null object
		boolean actual = administrator.modifyStore(null);
		assertFalse(actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#removeStore(java.util.List)}.
	 *
	 */
	@Test
	public void testRemoveStore () {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> list1 = new ArrayList<>();
		list.add(null);
		// test case-1 empty list
		int actual = administrator.removeStore(list);
		assertEquals(0, actual);
		// test case -2 list with proper data
		list1.add("PI1102");
		actual = administrator.removeStore(list1);
		assertEquals(1, actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#viewStore(java.lang.String)}.
	 *
	 */
	@Test
	public void testViewStore () {
		StoreBean store = new StoreBean();
		// TestCase-1 for null object
		store = administrator.viewStore(null);
		boolean actual = store instanceof StoreBean;
		assertEquals(true, actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#viewAllStore()}.
	 *
	 */
	@Test
	public void testViewAllStore () {
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#addFood(com.wipro.pos.bean.FoodBean)}.
	 */
	@Test
	public void testAddFood () {
		FoodBean food = new FoodBean();
		// TestCase-1 for null object
		String actual = administrator.addFood(null);
		assertEquals("FAIL", actual);
		// TestCase-2 for empty object
		actual = administrator.addFood(food);
		assertEquals("FAIL", actual);
		// TestCase-3 for correct object
		food.setFoodSize("medium");
		food.setName("pizza");
		food.setPrice(12);
		food.setType("nonveg");
		food.setQuantity(1);
		actual = administrator.addFood(food);
		assertEquals("SUCCESS", actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#modifyFood(com.wipro.pos.bean.FoodBean)}.
	 */
	@Test
	public void testModifyFood () {
		FoodBean food = new FoodBean();
		// 1-->
		boolean actual = administrator.modifyFood(null);
		assertFalse(actual);
		// 2-->
		actual = administrator.modifyFood(food);
		assertFalse(actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#removeFood(java.lang.String, java.lang.String)}.
	 *
	 */
	@Test
	public void testRemoveFood () {
		String foodid = null;
		// case -1
		boolean actual = administrator.removeFood(foodid);
		assertFalse(actual);
		// Case-2
		actual = administrator.removeFood(null);
		assertFalse(actual);
		// case-3 with correct data
		foodid = "";
		actual = administrator.removeFood(foodid);
		assertEquals(true, actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.AdministratorImpl#viewFood(java.lang.String)}.
	 *
	 * /*
	 *
	 * @Test public void testViewFood () { fail("Not yet implemented"); } /** Test method for
	 *       {@link com.wipro.pos.service.AdministratorImpl#viewAllFood(java.lang.String)}.
	 */
	/*
	 * @Test public void testViewAllFood () { fail("Not yet implemented"); } /** Test method for {@link
	 * com.wipro.pos.service.AdministratorImpl#changeOrderStatus(java.lang.String)}.
	 */
	/*
	 * @Test public void testChangeOrderStatus () { fail("Not yet implemented"); }
	 */
}

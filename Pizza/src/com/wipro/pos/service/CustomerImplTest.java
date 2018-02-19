/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CustomerImplTest.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Mar 13, 2015
 */


package com.wipro.pos.service;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.OrderBean;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Mar 13, 2015vi
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/Dispatcher-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class CustomerImplTest {

	@Autowired
	private Customer customer;
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#addToCart(com.wipro.pos.bean.CartBean)}.
	 */
	@Test
	public void testAddToCart () {
		CartBean cart = new CartBean();
		// Test case 1 with null object
		int actual = customer.addToCart(null);
		assertEquals(0, actual);
		// test case 2 with empty object
		actual = customer.addToCart(cart);
		assertEquals(0, actual);
		// test case 3 with correct data
		cart.setFoodID("VE1080");
		cart.setUserID("nidhi");
		cart.setQuantity(10);
		cart.setType("LARGE");
		actual = customer.addToCart(cart);
		assertEquals(1, actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#modifyCart(com.wipro.pos.bean.CartBean)}.
	 */
	@Test
	public void testModifyCart () {
		CartBean cart = new CartBean();
		// Test case 1 with null object
		boolean actual = customer.modifyCart(null);
		assertEquals(false, actual);
		// test case 2 with empty object
		actual = customer.modifyCart(cart);
		assertEquals(false, actual);
		// test case 3 with correct data
		cart.setFoodID("VE1080");
		cart.setUserID("nidhi");
		cart.setQuantity(10);
		cart.setType("LARGE");
		actual = customer.modifyCart(cart);
		assertEquals(true, actual);
	}
	/**
	 * Test method for
	 * {@link com.wipro.pos.service.CustomerImpl#confirmOrder(com.wipro.pos.bean.OrderBean, java.util.List)}.
	 */
	@Test
	public void testConfirmOrder () {
		OrderBean order = new OrderBean();
		List<CartBean> cart = new ArrayList<CartBean>();
		CartBean cartbean = new CartBean();
		// test case 1 null data
		String actual = customer.confirmOrder(null, null);
		assertEquals("INVALID", actual);
		// test case 2 for empty object
		actual = customer.confirmOrder(order, cart);
		assertEquals("INVALID", actual);
		// test case 3 for perfect data
		order.setCity("chennai");
		order.setMobileNo("9940155426");
		order.setPincode("102030");
		order.setState("Tamil nadu");
		order.setStoreID("PI1100");
		order.setStreet("mvp nagar");
		order.setUserID("nidhi");
		cartbean.setCartID(1041);
		cart.add(cartbean);
		actual = customer.confirmOrder(order, cart);
		assertEquals("SUCCESS", actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#cancelOrder(com.wipro.pos.bean.OrderBean)}.
	 */
	@Test
	public void testCancelOrder () {
		OrderBean order = new OrderBean();
		// test case 1 null data
		String actual = customer.cancelOrder(order);
		assertEquals("INVALID", actual);
		// test case 2 for empty object
		actual = customer.cancelOrder(order);
		assertEquals("INVALID", actual);
		// test case 3 for perfect data
		order.setCity("chennai");
		order.setMobileNo("9940155426");
		order.setPincode("102030");
		order.setState("Tamil nadu");
		order.setStoreID("PI1100");
		order.setStreet("mvp nagar");
		order.setUserID("nidhi");
		order.setCartID(1041);
		order.setOrderID("1080");
		order.setOrderStatus("CANCELLED");
		actual = customer.cancelOrder(order);
		assertEquals("SUCCESS", actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#viewStore(java.lang.String)}.
	 */
	@Test
	public void testViewStore () {
	}
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#viewCart(java.lang.String)}.
	 */
	@Test
	public void testViewCart () {
	}
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#viewOrder(java.lang.String)}.
	 */
	@Test
	public void testViewOrder () {
	}
	/**
	 * Test method for {@link com.wipro.pos.service.CustomerImpl#removeCart(java.lang.String)}.
	 */
	@Test
	public void testRemoveCart () {
		String cartId = null;
		// test case 1 null input
		int actual = customer.removeCart(null);
		assertEquals(0, actual);
		// test case 2 for empty input
		actual = customer.removeCart(cartId);
		assertEquals(0, actual);
		// test case 3 from corect data
		cartId = "1060";
		actual = customer.removeCart(cartId);
		assertEquals(1, actual);
	}
}

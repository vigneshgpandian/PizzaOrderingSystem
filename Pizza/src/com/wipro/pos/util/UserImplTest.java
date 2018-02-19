/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : UserImplTest.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 25, 2015
 */


package com.wipro.pos.util;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.ProfileBean;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 25, 2015
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:WebContent/WEB-INF/Dispatcher-servlet.xml" })
@TransactionConfiguration(transactionManager = "transactionManager")
@Transactional
public class UserImplTest {

	@Autowired
	private User user;
	/**
	 * Test method for {@link com.wipro.pos.util.UserImpl#login(com.wipro.pos.bean.CredentialsBean)}.
	 */
	@Test
	public void testLogin () {
		CredentialsBean credentialsBean = new CredentialsBean();
		// TestCase-1 for Admin login
		credentialsBean.setUserID("wipro");
		credentialsBean.setPassword("wipro@123");
		String actual = user.login(credentialsBean);
		assertEquals("A", actual);
		// TestCase-2 for User login
		credentialsBean.setUserID("nidhi");
		credentialsBean.setPassword("wipro@123");
		actual = user.login(credentialsBean);
		assertEquals("C", actual);
		// TestCase-3 for invalid user
		credentialsBean.setUserID("ravi");
		credentialsBean.setPassword("widfdfpro@123");
		actual = user.login(credentialsBean);
		assertEquals("INVALID", actual);
		// TestCase-4 for NULL
		actual = user.login(null);
		assertEquals("INVALID", actual);
		// TestCase-5 for null object
		actual = user.login(new CredentialsBean());
		assertEquals("INVALID", actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.util.UserImpl#logout(java.lang.String)}.
	 */
	@Test
	public void testLogout () {
		// TestCase-1 admin input
		boolean actual = user.logout("wipro");
		assertEquals(true, actual);
		// TestCase-2 null
		actual = user.logout(null);
		assertEquals(false, actual);
	}
	/**
	 * Test method for
	 * {@link com.wipro.pos.util.UserImpl#changePassword(com.wipro.pos.bean.CredentialsBean, java.lang.String)}.
	 */
	@Test
	public void testChangePassword () {
		CredentialsBean credentialsBean = new CredentialsBean();
		// TestCase-1 for proper data
		credentialsBean.setPassword("wipro@123");
		credentialsBean.setUserID("wipro");
		String newPassword = "wipro";
		String actual = user.changePassword(credentialsBean, newPassword);
		assertEquals("SUCCESS", actual);
		// TestCase-2 for null data
		credentialsBean.setPassword(null);
		actual = user.changePassword(credentialsBean, newPassword);
		assertEquals("INVALID", actual);
		// TestCase-3 for password is null
		credentialsBean.setPassword(null);
		newPassword = "wipro@123";
		actual = user.changePassword(credentialsBean, newPassword);
		assertEquals("INVALID", actual);
	}
	/**
	 * Test method for {@link com.wipro.pos.util.UserImpl#register(com.wipro.pos.bean.ProfileBean)}.
	 */
	@Test
	public void testRegister () {
		ProfileBean profile = new ProfileBean();
		CredentialsBean credentialsBean = new CredentialsBean();
		// TestCase-1 profile is null
		String actual = user.register(null);
		assertEquals("INVALID", actual);
		// TestCase-2 profile is empty
		actual = user.register(profile);
		assertEquals("INVALID", actual);
		// TestCase-3 some fields empty
		profile.setFirstName("vignesh");
		profile.setPassword("wipro@123");
		actual = user.register(profile);
		assertEquals("INVALID", actual);
	}
}

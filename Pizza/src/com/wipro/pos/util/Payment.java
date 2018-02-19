/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : Payment.java
 * Description   : This file is used to perform payment functionality.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.util;


import com.wipro.pos.bean.CreditCardBean;


/**
 * This class is used to perform payment functionality.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
public interface Payment {

	/**
	 * This method is used to finding user by card number.
	 *
	 * @param userid
	 *            to get user id.
	 * @param cardnumber
	 *            to get user card number.
	 * @return boolean
	 */
	boolean findByCardNumber (String userID, String cardnumber);
	/**
	 * This method is used to process payment.
	 *
	 * @param payment
	 *            to get the payment details.
	 * @return String
	 */
	String process (CreditCardBean card);
	/**
	 * This method is used to get the cash back
	 * 
	 * @param card
	 *            is credentialcardbeancard objcet
	 * @return string
	 */
	String cashBack (CreditCardBean card);
}

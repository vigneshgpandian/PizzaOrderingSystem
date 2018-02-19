/*
 * © Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name      : CreditCardDAO.java
 * Description    : This file is used to declare methods of CreditCard Interface
 * Version Number : 1.0
 * Created Date   : 20-FEB-2015
 */


package com.wipro.pos.dao;


import com.wipro.pos.bean.CreditCardBean;


/**
 * This class is used to declare methods of CreditCard Interface
 *
 * @author vignesh
 * @author nidhi archana
 * @version 1.0,20-FEB-2015
 * @since 1.0
 */
public interface CreditCardDAO {

	/**
	 * This method is used to search the card using userId
	 *
	 * @param userID
	 *            to get userId
	 * @return CreditCardBean as "CardBean of User"
	 */
	CreditCardBean findByID (String userID);
	/**
	 * This method is used to update Card
	 *
	 * @param cart
	 *            to update the card details
	 * @return boolean values
	 */
	boolean updateCreditCard (CreditCardBean creditcard);
}

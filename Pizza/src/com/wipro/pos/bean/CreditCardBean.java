/*
 * © Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name      : CreditCardBean.java
 * Description    : This file is used to set/get the CreditCard details
 * Version Number : 1.0
 * Created Date   : 20-FEB-2015
 */


package com.wipro.pos.bean;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class is used to set/get the creditcard details
 *
 * @author vignesh
 * @author Nidhi
 * @version 1.0,20-FEB-2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_User_Credit")
public class CreditCardBean {

	@Id
	@Column(name = "creditcardNo", length = 16)
	private String creditcardNo;
	@Column(name = "validFrom", length = 20, nullable = false)
	private Date validFrom;
	@Column(name = "validTo", length = 20, nullable = false)
	private Date validTo;
	@Column(name = "balance", length = 20, nullable = false)
	private double balance;
	@GeneratedValue
	@Column(name = "userID")
	private String userID;
	/**
	 * @return the creditcardNo
	 */
	public String getCreditcardNo () {
		return creditcardNo;
	}
	/**
	 * @param creditcardNo
	 *            to set the creditcardNo
	 */
	public void setCreditcardNo (final String creditcardNo) {
		this.creditcardNo = creditcardNo;
	}
	/**
	 * @return the validFrom
	 */
	/**
	 * @return the balance
	 */
	public double getBalance () {
		return balance;
	}
	/**
	 * @return the validFrom
	 */
	public Date getValidFrom () {
		return validFrom;
	}
	/**
	 * @param validFrom
	 *            the validFrom to set
	 */
	public void setValidFrom (final Date validFrom) {
		this.validFrom = validFrom;
	}
	/**
	 * @return the validTo
	 */
	public Date getValidTo () {
		return validTo;
	}
	/**
	 * @param validTo
	 *            the validTo to set
	 */
	public void setValidTo (final Date validTo) {
		this.validTo = validTo;
	}
	/**
	 * @param balance
	 *            to set the balance
	 */
	public void setBalance (final double balance) {
		this.balance = balance;
	}
	/**
	 * @return the userID
	 */
	public String getUserID () {
		return userID;
	}
	/**
	 * @param userID
	 *            to set the userID
	 */
	public void setUserID (final String userID) {
		this.userID = userID;
	}
}

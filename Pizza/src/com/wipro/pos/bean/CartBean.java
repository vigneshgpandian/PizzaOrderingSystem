/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CartBean.java
 * Description   : This file is used to set/get the cart details.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * This class is used to set/get the cart details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_User_Cart")
public class CartBean {

	@GeneratedValue
	@Column(name = "userID")
	private String userID;
	@GeneratedValue
	@Column(name = "foodID")
	private String foodID;
	@Column(name = "type", length = 20, nullable = false)
	private String type;
	@Id
	@OneToOne
	@JoinColumn(name = "cartID")
	private int cartID;
	@Column(name = "quantity", length = 20, nullable = false)
	private int quantity;
	@Column(name = "cost", length = 20, nullable = false)
	private double cost;
	/**
	 * @return the userID
	 */
	public String getUserID () {
		return userID;
	}
	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID (final String userID) {
		this.userID = userID;
	}
	/**
	 * @return the foodID
	 */
	public String getFoodID () {
		return foodID;
	}
	/**
	 * @param foodID
	 *            the foodID to set
	 */
	public void setFoodID (final String foodID) {
		this.foodID = foodID;
	}
	/**
	 * @return the type
	 */
	public String getType () {
		return type;
	}
	/**
	 * @param type
	 *            the type to set
	 */
	public void setType (final String type) {
		this.type = type;
	}
	/**
	 * @return the cartID
	 */
	public int getCartID () {
		return cartID;
	}
	/**
	 * @param cartID
	 *            the cartID to set
	 */
	public void setCartID (final int cartID) {
		this.cartID = cartID;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity () {
		return quantity;
	}
	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity (final int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the cost
	 */
	public double getCost () {
		return cost;
	}
	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost (final double cost) {
		this.cost = cost;
	}
}

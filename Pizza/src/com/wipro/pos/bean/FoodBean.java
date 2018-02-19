/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : FoodBean.java
 * Description   : This file is used to set/get the food details.
 * Version Number: 1.0
 * Created Date  : Feb 20, 2015
 */


package com.wipro.pos.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * This class is used to set/get the food details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 20, 2015
 * @since 1.0
 */
@Entity
@Table(name = "POS_TBL_User_Food")
public class FoodBean {

	@Id
	@OneToOne
	@JoinColumn(name = "foodID")
	private String foodID;
	@Column(name = "name", length = 20, nullable = false)
	private String name;
	@Column(name = "type", length = 20, nullable = false)
	private String type;
	@Column(name = "foodSize", length = 20, nullable = false)
	private String foodSize;
	@Column(name = "quantity", length = 20, nullable = false)
	private int quantity;
	@Column(name = "price", length = 20, nullable = false)
	private double price;
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
	 * @return the name
	 */
	public String getName () {
		return name;
	}
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName (final String name) {
		this.name = name;
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
	 * @return the foodSize
	 */
	public String getFoodSize () {
		return foodSize;
	}
	/**
	 * @param foodSize
	 *            the foodSize to set
	 */
	public void setFoodSize (final String foodSize) {
		this.foodSize = foodSize;
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
	 * @return the price
	 */
	public double getPrice () {
		return price;
	}
	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice (final double price) {
		this.price = price;
	}
}

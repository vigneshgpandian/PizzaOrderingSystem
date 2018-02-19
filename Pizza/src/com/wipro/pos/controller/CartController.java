/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : CartController.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Mar 4, 2015
 */


package com.wipro.pos.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.service.Customer;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Mar 4, 2015
 * @since 1.0
 */
@Controller
public class CartController {

	@Autowired
	private Administrator administrator;
	@Autowired
	private Customer customer;
	/**
	 * This method is used to view the store in the city.
	 *
	 * @param session
	 *            an object to http session.
	 * @return result
	 */
	@RequestMapping(value = "ViewCityStore")
	public ModelAndView ViewCityStore (final HttpSession session) {
		ModelAndView result = null;
		List<StoreBean> list = administrator.viewAllStore();
		result = new ModelAndView("ViewCityStore", "list", list);
		return result;
	}
	/**
	 * This method is used to get the details of the store in the city
	 *
	 * @param store
	 *            is an object to storebean
	 * @param session
	 *            is an object of http session
	 * @return result as details of the store in the city
	 */
	@RequestMapping(value = "CityStoreDetails", method = RequestMethod.POST)
	public ModelAndView ViewStore (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = new ModelAndView("ViewCityStore", "MSG", "Store Details Not Found");
		List<StoreBean> list = new ArrayList<StoreBean>();
		session.setAttribute("storeID", store.getStoreID());
		list = customer.viewStore(store.getCity());
		result = new ModelAndView("CityStoreDetails", "store", list);
		return result;
	}
	/**
	 * This method is used to view the items in the store
	 *
	 * @param food
	 *            is an object of foodbean
	 * @param session
	 *            object of session
	 * @return result as the item in the store
	 */
	@RequestMapping(value = "ViewFoodItems", method = RequestMethod.POST)
	public ModelAndView ViewFoodItems (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		List<FoodBean> list = new ArrayList<FoodBean>();
		list = administrator.viewAllFood();
		session.setAttribute("listfood", list);
		result = new ModelAndView("ViewFoodItems", "status", 0);
		return result;
	}
	/**
	 * This method is used to view the food details in the store
	 *
	 * @param cart
	 *            is an object of cartbean
	 * @param session
	 *            object of session
	 * @return result as the item details in the store
	 */
	@RequestMapping(value = "ViewFoodDetails")
	public ModelAndView viewfood (@ModelAttribute("cart") final CartBean cart, final HttpSession session) {
		ModelAndView result = null;
		FoodBean sto = administrator.viewFood(cart.getFoodID());
		session.setAttribute("sto", sto);
		result = new ModelAndView("ViewFoodItems", "food", sto);
		return result;
	}
	/**
	 * This method is used to add the food in the cart
	 *
	 * @param cart
	 *            is an object of cartbean
	 * @param res
	 *            is an object of bindingresult
	 * @param session
	 *            is an object of http sesion
	 * @return result with adding the items to the cart
	 */
	@RequestMapping(value = "AddToCart", method = RequestMethod.POST)
	public ModelAndView AddToCart (@Valid @ModelAttribute("cart") final CartBean cart, final BindingResult res,
			final HttpSession session) {
		ModelAndView result = null;
		if (res.hasErrors()) {
			result = new ModelAndView("ViewFoodItems", "food", session.getAttribute("sto"));
		} else {
			cart.setUserID((String) session.getAttribute("userID"));
			customer.addToCart(cart);
			result = new ModelAndView("ViewFoodItems", "MSG", "item added to cart");
		}
		return result;
	}
	/**
	 * This method is used to view the food in the cart
	 *
	 * @param cart
	 *            is an object of cartbean
	 * @param session
	 *            session is an object of http sesion
	 * @return result as view the items in the cart
	 */
	@RequestMapping(value = "ViewCart")
	public ModelAndView ViewCart (@ModelAttribute("cart") final CartBean cart, final HttpSession session) {
		ModelAndView result = null;
		List<CartBean> list = new ArrayList<CartBean>();
		String id = (String) session.getAttribute("userID");
		list = customer.viewCart(id);
		result = new ModelAndView("ViewCart", "list", list);
		return result;
	}
	/**
	 * This method is used to modify the food in the cart
	 *
	 * @param cart
	 *            is an object of cartbean
	 * @param session
	 *            session is an object of http sesion
	 * @return result as the modification in the cart
	 */
	@RequestMapping(value = "ModifyCart")
	public ModelAndView ModifyCart (@ModelAttribute("cart") final CartBean cart, final HttpSession session) {
		ModelAndView result = null;
		customer.modifyCart(cart);
		List<CartBean> list = new ArrayList<CartBean>();
		String id = (String) session.getAttribute("userID");
		list = customer.viewCart(id);
		result = new ModelAndView("ViewCart", "list", list);
		return result;
	}
	/**
	 * This method is used to delete the food in the cart
	 *
	 * @param cartID
	 *            is the id of the cart
	 * @param session
	 *            session is an object of http sesion
	 * @return result as the item deleted in the cart
	 */
	@RequestMapping(value = "DeleteCart")
	public ModelAndView DeleteCart (@RequestParam("cartID") final String cartID, final HttpSession session) {
		ModelAndView result = null;
		customer.removeCart(cartID);
		result = new ModelAndView("Deleted", "MSG", "Food item removed from cart");
		return result;
	}
	/**
	 * This method is used to redirect to delete cart
	 *
	 * @param cart
	 *            is an object of cartbean
	 * @param session
	 *            session is an object of http sesion
	 * @return result as the list in the deleted cart
	 */
	@RequestMapping(value = "DeleteCartRedirect")
	public ModelAndView DeleteCartRedirect (@ModelAttribute("cart") final CartBean cart, final HttpSession session) {
		ModelAndView result = null;
		List<CartBean> list = new ArrayList<CartBean>();
		String id = (String) session.getAttribute("userID");
		list = customer.viewCart(id);
		result = new ModelAndView("ViewCart", "list", list);
		return result;
	}
}

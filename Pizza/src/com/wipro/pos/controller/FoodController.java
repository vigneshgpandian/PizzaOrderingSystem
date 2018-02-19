/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : FoodController.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 26, 2015
 */


package com.wipro.pos.controller;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.service.Administrator;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 26, 2015
 * @since 1.0
 */
@Controller
public class FoodController {

	@Autowired
	private Administrator administrator;
	/**
	 * This method is to add food
	 *
	 * @param model
	 *            is an Model object
	 * @return foodAdd
	 */
	@RequestMapping(value = "FoodAdd", method = RequestMethod.GET)
	public String AddFood (final Model model, final HttpSession session) {
		if (session.getAttribute("userID") instanceof String) {
			model.addAttribute("food", new FoodBean());
			return "FoodAdd";
		} else {
			return "loginfail";
		}
	}
	/**
	 * This method is used to add food
	 *
	 * @param food
	 *            is feedbean object
	 * @param res
	 *            is bidingresult object
	 * @param session
	 *            is http session object
	 * @return success/failure
	 */
	@RequestMapping(value = "FoodAdd", method = RequestMethod.POST)
	public ModelAndView CreateStore (@Valid @ModelAttribute("food") final FoodBean food, final BindingResult res,
			final HttpSession session) {
		ModelAndView result = new ModelAndView("FoodAdd", "MSG", "food Details Not Added");
		String status = "FAIL";
		if (res.hasErrors()) {
			result = new ModelAndView("FoodAdd", "MSG", "");
		} else {
			status = administrator.addFood(food);
			if ("SUCCESS".equals(status)) {
				result = new ModelAndView("AdminHome", "MSG", "Food Details added Sucessfully For Food ID:"
						+ food.getFoodID());
			}
		}
		return result;
	}
	/**
	 * This metjod is used to view all food
	 *
	 * @return list of food
	 */
	@RequestMapping(value = "ViewAllFood")
	public ModelAndView ViewAllFood () {
		ModelAndView result = null;
		List<FoodBean> list = administrator.viewAllFood();
		result = new ModelAndView("ViewAllFood", "list", list);
		return result;
	}
	/**
	 * This method is used to modify the food
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return modify food
	 */
	@RequestMapping(value = "ModifyFood")
	public ModelAndView Modifyfood (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		List<FoodBean> listfood = administrator.viewAllFood();
		session.setAttribute("listfood", listfood);
		result = new ModelAndView("ModifyFood", "status", 0);
		return result;
	}
	/**
	 * This method is to confirm the modification
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "ConformMofifyFood")
	public ModelAndView ConformModify (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		result = new ModelAndView("ModifyFood", "MSG", "");
		FoodBean sto = administrator.viewFood(food.getFoodID());
		result = new ModelAndView("ModifyFood", "food", sto);
		return result;
	}
	/**
	 * This method is used to modify the food
	 *
	 * @param food
	 *            is foodbean object
	 * @param res
	 *            is bidingresult object
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "ModifyFood", method = RequestMethod.POST)
	public ModelAndView ModifyTheStore (@Valid @ModelAttribute("food") final FoodBean food, final BindingResult res,
			final HttpSession session) {
		ModelAndView result = null;
		if (res.hasErrors()) {
			result = new ModelAndView("ModifyFood", "MSG", "");
		} else {
			boolean status = administrator.modifyFood(food);
			result = new ModelAndView("AdminHome", "MSG", "Food Details Modified Sucessfully For Food ID:"
					+ food.getFoodID());
		}
		return result;
	}
	/**
	 * This method to view food
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "ViewFood")
	public ModelAndView ViewStoreId (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		List<FoodBean> listfood = administrator.viewAllFood();
		session.setAttribute("listfood", listfood);
		result = new ModelAndView("ViewFood", "status", 0);
		return result;
	}
	/**
	 * This method to view food details
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "FoodDetails")
	public ModelAndView ViewStore (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		FoodBean sto = administrator.viewFood(food.getFoodID());
		result = new ModelAndView("ViewFood", "food", sto);
		return result;
	}
	/**
	 * This method to delete food details
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "DeleteFood")
	public ModelAndView DeleteFood (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		List<FoodBean> listfood = administrator.viewAllFood();
		session.setAttribute("listfood", listfood);
		result = new ModelAndView("DeleteFood", "status", 0);
		return result;
	}
	/**
	 * This method to delete food details
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "ConformDeleteFood")
	public ModelAndView ConformDelete (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = null;
		FoodBean sto = administrator.viewFood(food.getFoodID());
		result = new ModelAndView("DeleteFood", "food", sto);
		return result;
	}
	/**
	 * This method to delete food details
	 *
	 * @param food
	 *            is foodbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "DeleteFood", method = RequestMethod.POST)
	public ModelAndView DeleteTheFood (@ModelAttribute("food") final FoodBean food, final HttpSession session) {
		ModelAndView result = new ModelAndView("AdminHome", "MSG", "Food Item Deleted With Food ID:" + food.getFoodID());
		administrator.removeFood(food.getFoodID());
		return result;
	}
}

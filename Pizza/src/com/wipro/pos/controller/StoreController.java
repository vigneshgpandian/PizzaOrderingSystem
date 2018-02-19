/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : StoreController.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 25, 2015
 */


package com.wipro.pos.controller;


import java.util.ArrayList;
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

import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.service.Administrator;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 25, 2015
 * @since 1.0
 */
@Controller
public class StoreController {

	@Autowired
	private Administrator administrator;
	/**
	 * This method is used to redirect to storeadd
	 * 
	 * @param model
	 *            is Model oject
	 * @return storeadd
	 */
	@RequestMapping(value = "StoreAdd", method = RequestMethod.GET)
	public String AddStore (final Model model) {
		model.addAttribute("store", new StoreBean());
		return "StoreAdd";
	}
	/**
	 * This method is used to store the details added
	 * 
	 * @param store
	 *            is object of the store bean
	 * @param res
	 *            is resultbinding object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "StoreAdd", method = RequestMethod.POST)
	public ModelAndView CreateStore (@Valid @ModelAttribute("store") final StoreBean store, final BindingResult res,
			final HttpSession session) {
		ModelAndView result = null;
		String status = null;
		if (res.hasErrors()) {
			result = new ModelAndView("StoreAdd", "MSG", "Enter the required details.");
		} else {
			status = administrator.addStore(store);
			result = new ModelAndView("StoreAdd", "MSG", "Unable to add Store Details");
			if ("SUCCESS".equals(status)) {
				result = new ModelAndView("AdminHome", "MSG", "Details Added Successfully for Store ID:"
						+ store.getStoreID());
			}
		}
		return result;
	}
	/**
	 * This method is used to viewstore
	 * 
	 * @param store
	 *            is object of the store bean
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "ViewStore")
	public ModelAndView ViewStoreId (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = null;
		List<StoreBean> list = administrator.viewAllStore();
		session.setAttribute("list", list);
		result = new ModelAndView("ViewStore", "status", 0);
		return result;
	}
	/**
	 * This method is used to get store details
	 * 
	 * @param store
	 *            is object of the store bean
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "StoreDetails")
	public ModelAndView ViewStore (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = new ModelAndView("StoreAdd", "MSG", "Store Details Not Added");
		StoreBean sto = administrator.viewStore(store.getStoreID());
		result = new ModelAndView("ViewStore", "store", sto);
		return result;
	}
	/**
	 * This method is used to view all store details
	 * 
	 * @return result
	 */
	@RequestMapping(value = "ViewAllStore")
	public ModelAndView ViewAllStore () {
		ModelAndView result = null;
		List<StoreBean> list = administrator.viewAllStore();
		result = new ModelAndView("ViewAllStore", "list", list);
		return result;
	}
	/**
	 * This method is used to delete store details
	 * 
	 * @param store
	 *            store is object of the store bean
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "DeleteStore")
	public ModelAndView DeleteStore (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = null;
		List<StoreBean> list = administrator.viewAllStore();
		session.setAttribute("list", list);
		result = new ModelAndView("DeleteStore", "status", 0);
		return result;
	}
	/**
	 * This method is used to confirm delete store details
	 * 
	 * @param store
	 *            store is object of the store bean
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "ConformDelete")
	public ModelAndView ConformDelete (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = new ModelAndView("StoreAdd", "MSG", "Store Details Not Added");
		StoreBean sto = administrator.viewStore(store.getStoreID());
		result = new ModelAndView("DeleteStore", "store", sto);
		return result;
	}
	/**
	 * This method is used to delete store details
	 * 
	 * @param store
	 *            store is object of the store bean
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "DeleteStore", method = RequestMethod.POST)
	public ModelAndView DeleteTheStore (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = new ModelAndView("AdminHome", "MSG", "The Store Details Deleted Store ID:"
				+ store.getStoreID());
		ArrayList<String> storeId = new ArrayList<String>();
		storeId.add(store.getStoreID());
		administrator.removeStore(storeId);
		return result;
	}
	/**
	 * This method is used to modify store details
	 * 
	 * @param store
	 *            store is object of the store bean
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "ModifyStore")
	public ModelAndView ModifyStore (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = null;
		List<StoreBean> list = administrator.viewAllStore();
		session.setAttribute("list", list);
		result = new ModelAndView("ModifyStore", "status", 0);
		return result;
	}
	/**
	 * This method is used to confirm modify store details
	 * 
	 * @param store
	 *            store is object of the store bean
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "ConformMofify")
	public ModelAndView ConformModify (@ModelAttribute("store") final StoreBean store, final HttpSession session) {
		ModelAndView result = null;
		StoreBean sto = administrator.viewStore(store.getStoreID());
		result = new ModelAndView("ModifyStore", "store", sto);
		return result;
	}
	/**
	 * This method is used to modify store details
	 * 
	 * @param store
	 *            store is object of the store bean
	 * @param res
	 *            is bindingresult object
	 * @param session
	 *            session is http session object
	 * @return result
	 */
	@RequestMapping(value = "ModifyStore1", method = RequestMethod.POST)
	public ModelAndView ModifyTheStore (@Valid @ModelAttribute("store") final StoreBean store, final BindingResult res,
			final HttpSession session) {
		ModelAndView result = null;
		if (res.hasErrors()) {
			result = new ModelAndView("ModifyStore", "MSG", "");
		} else {
			boolean status = administrator.modifyStore(store);
			result = new ModelAndView("AdminHome", "MSG", "Store Details Modified Sucessfully For Store ID:"
					+ store.getStoreID());
		}
		return result;
	}
}

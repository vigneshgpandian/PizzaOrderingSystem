/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : ProfileController.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Feb 24, 2015
 */


package com.wipro.pos.controller;


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

import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.util.User;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Feb 24, 2015
 * @since 1.0
 */
@Controller
public class ProfileController {

	@Autowired
	private User user;
	/**
	 * This method is used to direct to registration
	 * 
	 * @param model
	 *            is Model obejct
	 * @return registration
	 */
	@RequestMapping(value = "Registration", method = RequestMethod.GET)
	public String viewRegistration (final Model model) {
		model.addAttribute("profile", new ProfileBean());
		return "Registration";
	}
	/**
	 * This method is used to direct to registration
	 * 
	 * @param profile
	 *            object of profilebean
	 * @param res
	 *            is binding result
	 * @param session
	 *            is http session object
	 * @return Success/faliure
	 */
	@RequestMapping(value = "Registration", method = RequestMethod.POST)
	public ModelAndView registration (@Valid @ModelAttribute("profile") final ProfileBean profile,
			final BindingResult res, final HttpSession session) {
		ModelAndView result = new ModelAndView("Registration", "MSG", "INVALID");
		String status = "INVALID";
		if (res.hasErrors()) {
			result = new ModelAndView("Registration", "MSG", "");
		} else {
			status = user.register(profile);
			if (!"INVALID".equals(status)) {
				result = new ModelAndView("Success", "MSG", "Your user ID is " + status);
			} else {
				result = new ModelAndView("Failure", "MSG", "Unable to create the Profile");
			}
		}
		return result;
	}
}

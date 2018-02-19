/*
 * © Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name      : CredentialsController.java
 * Description    : This file is used to set/get the credentials details.
 * Version Number : 1.0
 * Created Date   : Feb 20, 2015
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

import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.util.User;


/**
 * This class is used to set/get the credentials details.
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0, Feb 20, 2015
 * @since 1.0
 */
@Controller
public class CredentialsController {

	@Autowired
	private User user;
	/**
	 * This method is used to redirect to userlogin
	 *
	 * @param model
	 *            is an object of Model
	 * @return userlogin
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String viewLogin (final Model model) {
		model.addAttribute("credentials", new CredentialsBean());
		return "UserLogin";
	}
	/**
	 * This method is used to redirect to customerhome or adminhome
	 *
	 * @param credentials
	 *            are the credentials of the user
	 * @param resis
	 *            the binding result object
	 * @param session
	 *            is the object of http session
	 * @return the desired homepage
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login (@Valid @ModelAttribute("credentials") final CredentialsBean credentials,
			final BindingResult res, final HttpSession session) {
		ModelAndView result = new ModelAndView("UserLogin", "MSG", "INVALID User Details");
		String status = user.login(credentials);
		if (res.hasErrors()) {
			result = new ModelAndView("UserLogin", "MSG", "Enter the details");
		} else {
			if ("A".equals(status)) {
				session.setAttribute("userID", credentials.getUserID());
				session.setAttribute("userType", status);
				result = new ModelAndView("AdminHome", "MSG", "Welcome Mr " + credentials.getUserID());
			} else if ("C".equals(status)) {
				session.setAttribute("userID", credentials.getUserID());
				session.setAttribute("userType", status);
				result = new ModelAndView("CustomerHome", "MSG", "Logged In As " + credentials.getUserID());
			}
		}
		session.setAttribute("nameheader", credentials.getUserID());
		return result;
	}
	/**
	 * This method is used to logout from the session
	 *
	 * @param model
	 *            is an object of Model
	 * @param session
	 *            is the object of http session
	 * @return the userlogin with logout message
	 */
	@RequestMapping(value = "Logout")
	public ModelAndView logout (final Model model, final HttpSession session) {
		model.addAttribute("credentials", new CredentialsBean());
		ModelAndView result = null;
		String userID = (String) session.getAttribute("userID");
		String userType = (String) session.getAttribute("userType");
		if (userID instanceof String) {
			boolean flag = user.logout(userID);
			if (flag) {
				session.invalidate();
				result = new ModelAndView("UserLogin", "MSG", "You Have Sucessfully Logged Out");
			} else {
				if ("A".equals(userType)) {
					result = new ModelAndView("AdminHome", "MSG", "please wait some process is goin on ");
				} else {
					result = new ModelAndView("CustomerHome", "MSG", "please wait some process is goin on ");
				}
			}
			return result;
		} else {
			return new ModelAndView("loginfail", "MSG", "your session is expired pls login ");
		}
	}
	/**
	 * This redirects to password
	 *
	 * @param model
	 *            is an object of Model
	 * @return the password
	 */
	@RequestMapping(value = "Password")
	public String viewPassword (final Model model) {
		model.addAttribute("profile", new ProfileBean());
		return "Password";
	}
	/*
	 * @RequestMapping(value = "changePassword", method = RequestMethod.POST) public ModelAndView Password
	 * (@RequestParam final String newpassword, final String ConformPassword, final String Password, final HttpSession
	 * session) { ModelAndView status = null; CredentialsBean credentials = new CredentialsBean(); String userID =
	 * (String) session.getAttribute("userID"); credentials.setUserID(userID); credentials.setPassword(Password); String
	 * result = user.changePassword(credentials, newpassword); if (result.equals("SUCESS")) { status = new
	 * ModelAndView("Success", "MSG", "password changed sucessfully!!!"); } else { status = new ModelAndView("Failure",
	 * "MSG", "worng password enter!!!!"); } return status;
	 */
	/**
	 * This method is to change the password
	 *
	 * @param profile
	 *            is an object of the profile bean
	 * @param res
	 *            is bindingresult object
	 * @param session
	 *            is an http session object
	 * @return the changed password
	 */
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public ModelAndView password (@Valid @ModelAttribute("profile") final ProfileBean profile, final BindingResult res,
			final HttpSession session) {
		ModelAndView status = null;
		/*
		 * if (res.hasErrors()) { status = new ModelAndView("Password", "MSG", ""); } else {
		 */
		CredentialsBean credentials = new CredentialsBean();
		credentials.setPassword(profile.getPassword());
		credentials.setUserID((String) session.getAttribute("userID"));
		String result = user.changePassword(credentials, profile.getConformPassword());
		if ("SUCCESS".equals(result)) {
			status = new ModelAndView("Success", "MSG", "password changed sucessfully!!!");
		} else {
			status = new ModelAndView("Password", "MSG", "worng password enter!!!!");
		}
		return status;
	}
	/**
	 * This method is used to redirect to Aboutus page
	 *
	 * @param model
	 *            is an object of Model
	 * @return Aboutus
	 */
	@RequestMapping(value = "Aboutus", method = RequestMethod.GET)
	public String viewAbout (final Model model) {
		model.addAttribute("credentials", new CredentialsBean());
		return "Aboutus";
	}
	/**
	 * This method is used to redirect to Contactus page
	 *
	 * @param model
	 *            is an object of Model
	 * @return Contactus
	 */
	@RequestMapping(value = "Contactus", method = RequestMethod.GET)
	public String viewContact (final Model model) {
		model.addAttribute("credentials", new CredentialsBean());
		return "Contactus";
	}
}

/*
 * ©Copyright 2015 Wipro Technologies. All Rights Reserved.
 * File Name     : OrderController.java
 * Description   : This file is used to set/get the credentials.
 * Version Number: 1.0
 * Created Date  : Mar 11, 2015
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
import org.springframework.web.servlet.ModelAndView;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.CreditCardBean;
import com.wipro.pos.bean.OrderBean;
import com.wipro.pos.service.Customer;
import com.wipro.pos.util.Payment;


/**
 * This class is used to set/get the credentials details
 *
 * @author Vignesh
 * @author Nidhi Archana
 * @version 1.0 Mar 11, 2015
 * @since 1.0
 */
@Controller
public class OrderController {

	@Autowired
	private Payment payment;
	@Autowired
	private Customer customer;
	/**
	 * This method is used to make order
	 *
	 * @param order
	 *            is object of oreder bean
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "MakeOrder")
	public ModelAndView MakeOrder (@ModelAttribute("order") final OrderBean order, final HttpSession session) {
		ModelAndView result = null;
		result = new ModelAndView("MakeOrder");
		return result;
	}
	/**
	 * This method is used to wait
	 *
	 * @param order
	 *            is object of oreder bean
	 * @param res
	 *            is binding result object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "pleasewait")
	public ModelAndView pleasewait (@Valid @ModelAttribute("order") final OrderBean order, final BindingResult res,
			final HttpSession session) {
		ModelAndView result = null;
		if (res.hasErrors()) {
			result = new ModelAndView("MakeOrder");
		} else {
			session.setAttribute("order", order);
			result = new ModelAndView("pleasewait");
		}
		return result;
	}
	/**
	 * This method is used to get payment details
	 *
	 * @param card
	 *            is object of cardbean
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "PaymentDetails")
	public ModelAndView MakePayment (@ModelAttribute("card") final CreditCardBean card, final HttpSession session) {
		ModelAndView result = null;
		result = new ModelAndView("PaymentDetails");
		return result;
	}
	/**
	 * This method is used to pay
	 *
	 * @param card
	 *            is object of cardbean
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "Pay")
	public ModelAndView Pay (@ModelAttribute("card") final CreditCardBean card, final HttpSession session) {
		ModelAndView result = null;
		String userId = (String) session.getAttribute("userID");
		boolean flag = false;
		result = new ModelAndView("Pay", "MSG", "failure");
		flag = payment.findByCardNumber((String) session.getAttribute("userID"), card.getCreditcardNo());
		OrderBean order = new OrderBean();
		order = (OrderBean) session.getAttribute("order");
		order.setUserID(userId);
		order.setStoreID((String) session.getAttribute("storeID"));
		if (flag) {
			card.setUserID(userId);
			payment.process(card);
			List<CartBean> list = new ArrayList<CartBean>();
			list = customer.viewCart((String) session.getAttribute("userID"));
			for (CartBean cartB : list) {
				List<CartBean> cart = new ArrayList<CartBean>();
				cart.add(cartB);
				customer.confirmOrder(order, cart);
				cart.remove(0);
			}
			result = new ModelAndView("Pay", "MSG", "Placed order");
		} else {
			result = new ModelAndView("Pay", "MSG", "Insuffecient Balance");
		}
		return result;
	}
	/**
	 * This method is used to view order
	 *
	 * @param order
	 *            is orderbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "ViewOrder")
	public ModelAndView ViewOrder (@ModelAttribute("order") final OrderBean order, final HttpSession session) {
		ModelAndView result = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		list = customer.viewOrder((String) session.getAttribute("userID"));
		List<CartBean> cartlist = new ArrayList<CartBean>();
		cartlist = customer.viewCart((String) session.getAttribute("userID"));
		session.setAttribute("cartlist", cartlist);
		result = new ModelAndView("ViewOrder", "list", list);
		return result;
	}
	/**
	 * This method is used to cancel order
	 *
	 * @param order
	 *            is orderbean object
	 * @param session
	 *            is http session object
	 * @return result
	 */
	@RequestMapping(value = "CancelOrder")
	public ModelAndView CancelOrder (@ModelAttribute("order") final OrderBean order, final HttpSession session) {
		ModelAndView result = null;
		List<OrderBean> list = new ArrayList<OrderBean>();
		list = customer.viewOrder((String) session.getAttribute("userID"));
		// payment.cashBack();
		for (OrderBean orderlist : list) {
			customer.cancelOrder(orderlist);
		}
		result = new ModelAndView("Pay", "MSG", "Order canceled");
		return result;
	}
}

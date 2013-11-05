package com.blackcrowsys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author rahulsingh
 * 
 * Default controller. This determines which URL the user
 * goes to after login. This is not executed if the user
 * tried to access a protected part of the application
 * prior to login.
 * 
 */
@Controller
public class DefaultController {

	/**
	 * Send an Admin user to the admin section; otherwise
	 * redirect the user to the homepage.
	 * 
	 * @param request the http request
	 * @return String view
	 */
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String defaultAfterLogin(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_ADMIN")) {
			return "redirect:/admin";
		}
		return "redirect:/";
	}
}

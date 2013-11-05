package com.blackcrowsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author rahulsingh
 *
 * Login controller to produce the login form only. We let
 * Spring Security handle the rest of the authentication work.
 * 
 */
@Controller
public class LoginController {

	/**
	 * Simple request mapping to the login form.
	 * 
	 * @return String view
	 */
	@RequestMapping(value = "/login/form", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
}

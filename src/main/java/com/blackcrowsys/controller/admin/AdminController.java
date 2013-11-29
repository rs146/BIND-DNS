package com.blackcrowsys.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.blackcrowsys.dataaccess.user.UserDao;

/**
 * Access the administration information.
 * @author rahulsingh
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserDao userDao;

	/**
	 * Display the list of users.
	 * 
	 * @param model mvc model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showUserList(ModelMap model) {

		model.addAttribute("users", userDao.findAllUsers());

		return "admin/list";
	}
}

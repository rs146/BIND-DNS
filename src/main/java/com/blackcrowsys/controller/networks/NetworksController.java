package com.blackcrowsys.controller.networks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author rahulsingh
 * 
 * Access the Network information contained in the management system.
 */
@Controller
@RequestMapping("/networks")
public class NetworksController {
	
	/**
	 * Display the list of networks
	 * 
	 * @param model mvc model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showNetworksList(ModelMap model) {
		
		return "networks/list";
	}
}

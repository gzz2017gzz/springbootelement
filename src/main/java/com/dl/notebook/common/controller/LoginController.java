package com.dl.notebook.common.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@SuppressWarnings("unused")
	private Log logger = LogFactory.getLog(getClass());
 
	@RequestMapping({ "/" })
	public String index() {
		return "index";
	}
 
}

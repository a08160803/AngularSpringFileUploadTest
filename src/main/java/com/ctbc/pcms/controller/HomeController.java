package com.ctbc.pcms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("======== HomeController ===========");
	}

	@RequestMapping(value = "/")
	public String toIndex() {
		return "index";
	}

}

package com.ctbc.pcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctbc.pcms.model.dao.FM001Dao;

@Controller
public class HomeController {

	@Autowired
	private FM001Dao fm001Dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		Integer max = fm001Dao.selectMax();
		fm001Dao.insert(max);
		max = fm001Dao.selectMax();
		fm001Dao.insert2(max);
		fm001Dao.selectMax();
		return "index";
	}
	
}
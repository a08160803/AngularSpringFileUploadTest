package com.ctbc.pcms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FM003Controller {

	@RequestMapping(value = "/FM003/inquire", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> inquire() {
		Map<String, Object> responseMap = new HashMap<String, Object>();
		return responseMap;
	}
	
}

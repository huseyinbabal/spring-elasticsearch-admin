package com.cubuzoa.springelasticsearchmonitor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndicesController {
	@RequestMapping(method = RequestMethod.GET, value = {"/indices"})
	public String indices(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "indices/layout";
	}
}
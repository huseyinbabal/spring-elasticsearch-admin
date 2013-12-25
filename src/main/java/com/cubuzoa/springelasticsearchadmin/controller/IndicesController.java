package com.cubuzoa.springelasticsearchadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/indices")
public class IndicesController {

    @RequestMapping("/layout")
    public String getIndicesPartialPage(ModelMap modelMap) {
        return "indices/layout";
    }
}
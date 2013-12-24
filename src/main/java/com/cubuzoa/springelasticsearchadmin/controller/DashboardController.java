package com.cubuzoa.springelasticsearchadmin.controller;

import com.cubuzoa.springelasticsearchadmin.service.impl.ElasticsearchServiceImpl;
import com.google.gson.JsonObject;
import io.searchbox.client.JestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ElasticsearchServiceImpl elasticsearchServiceImpl;

    @RequestMapping("/layout")
    public String getDashboardPartialPage(ModelMap modelMap) {
        modelMap.addAttribute("health", getServerHealth());
        modelMap.addAttribute("state", getServerState());
        return "dashboard/layout";
    }

    /**
     * Returns the server health information
     * @return
     */
    public JsonObject getServerHealth() {
        try {
            JestResult jestResult = elasticsearchServiceImpl.getServerHealth();
            return jestResult.getJsonObject();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Returns the server state information
     * @return
     */
    public JsonObject getServerState() {
        try {
            JestResult jestResult = elasticsearchServiceImpl.getServerState();
            return jestResult.getJsonObject();
        } catch (Exception e) {
            return null;
        }
    }

}
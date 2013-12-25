package com.cubuzoa.springelasticsearchadmin.controller;

import com.cubuzoa.springelasticsearchadmin.service.impl.ElasticsearchServiceImpl;
import com.google.gson.JsonObject;
import io.searchbox.client.JestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;

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

    @RequestMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getDashboardHealth() {
        JsonObject jsonObject = getServerHealth();
        return jsonObject.toString();
    }

    @RequestMapping(value = "/state", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getDashboardState() {
        JsonObject jsonObject = getServerState();
        return jsonObject.toString();
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
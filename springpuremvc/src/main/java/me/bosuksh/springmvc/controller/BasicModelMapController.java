package me.bosuksh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicModelMapController {

    @RequestMapping("/welcome-model-map")
    public String modelAndMap(ModelMap modelMap) {
        modelMap.put("name","xyz");
        return "welcome-model-map";
    }
}

package me.bosuksh.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @RequestMapping(value = "/welcome")
    @ResponseBody
    public String welcome() {
        return "Welcome to Spring MVC";
    }

    @RequestMapping(value = "welcome-view")
    public String welcomeView() {
        return "welcome";
    }
}

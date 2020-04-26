package me.bosuksh.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BasicModelViewController {
    @RequestMapping("/welcome-model-and-view")
    public ModelAndView welcome(ModelMap modelMap) {
        modelMap.put("name","abc");
        return new ModelAndView("welcome-model-and-view",modelMap);
    }
}

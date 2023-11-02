package com.bolsasdeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // @GetMapping("/index")
    @GetMapping(value = {"/index", "/", "/home"})
    public String index(Model model){
        model.addAttribute("title", "Hallo Spring Framework");
        return "index";
    }

}

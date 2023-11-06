package com.bolsasdeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VblesRouteController {

    @GetMapping("/string/{myText}")
    public String variables(@PathVariable String myText, Model model) {
        model.addAttribute("title", "Receiving parameters from (@PathVariable)");
        model.addAttribute("result", "The route sending text is: " + myText);
        return "variables/see";
    }

}

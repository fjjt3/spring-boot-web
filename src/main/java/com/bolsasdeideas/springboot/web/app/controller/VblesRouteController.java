package com.bolsasdeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VblesRouteController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Sending parameters from (@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{myText}")
    public String variables(@PathVariable String myText, Model model) {
        model.addAttribute("title", "Receiving parameters from (@PathVariable)");
        model.addAttribute("result", "The route sending text is: " + myText);
        return "variables/see";
    }

    @GetMapping("/string/{myText}/{number}")
    public String variables(@PathVariable String myText,@PathVariable Integer number , Model model) {
        model.addAttribute("title", "Receiving parameters from (@PathVariable)");
        model.addAttribute("result", "The route sending text is: " + myText
            + " and the sending number is: " + number);
        return "variables/see";
    }

}

package com.bolsasdeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsExampleController {

    @GetMapping("/string")
    public String param(@RequestParam(name="myText", required=false, defaultValue = "some value") String myText, Model model){
        model.addAttribute("result", "the sended text is: " + myText);

        return "params/see";
    }
}

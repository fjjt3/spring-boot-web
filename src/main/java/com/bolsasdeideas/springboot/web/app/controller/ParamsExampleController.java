package com.bolsasdeideas.springboot.web.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsExampleController {

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name="myText", required=false, defaultValue = "some value") String myText, Model model){
        model.addAttribute("result", "the sended text is: " + myText);
        return "params/see";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String regard, @RequestParam Integer  number, Model model){
        model.addAttribute("result", "The regard is: '" + regard +"' and the number is: '" + number +"'");

        return "params/see";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String regard = request.getParameter("regard");
        Integer number = null;
        try{
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }

        model.addAttribute("result", "The regard is: '" + regard +"' and the number is: '" + number +"'");

        return "params/see";

}
}

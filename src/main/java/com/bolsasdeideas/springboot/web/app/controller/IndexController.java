package com.bolsasdeideas.springboot.web.app.controller;

import com.bolsasdeideas.springboot.web.app.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping(value = {"/index", "/", "", "/home"})
    public String index(Model model){
        model.addAttribute("title", "Hallo Spring Framework");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        User user = new User();
        user.setName("Jeff");
        user.setLastname("Mills");
        user.setEmail("jeff@gmail.com");

        model.addAttribute("user", user);
        model.addAttribute("title", "User Profile ".concat(user.getName()));


        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model){
;       List<User> users = Arrays.asList(new User("Jeff", "Mills","jf@gmail.com"));


        model.addAttribute("title", "Users List ");
        model.addAttribute("users", users);
        return "list";
    }

}

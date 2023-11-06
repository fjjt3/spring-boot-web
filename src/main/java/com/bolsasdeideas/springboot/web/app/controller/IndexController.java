package com.bolsasdeideas.springboot.web.app.controller;

import com.bolsasdeideas.springboot.web.app.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${text.indexcontroller.index.title:}")
    private String textIndex;

    @Value("${text.indexcontroller.profile.title:}")
    private String textProfile;

    @Value("${text.indexcontroller.list.title:}")
    private String textList;



    @GetMapping(value = {"/index", "/", "", "/home"})
    public String index(Model model){
        model.addAttribute("title", textIndex);
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        User user = new User();
        user.setName("Jeff");
        user.setLastname("Mills");
        user.setEmail("jeff@gmail.com");

        model.addAttribute("user", user);
        model.addAttribute("title", textProfile.concat(user.getName()));


        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute(textList, "Users List ");
        return "list";
    }

    @ModelAttribute("users")
    public List<User> populateUsers(){
        List<User> users = Arrays.asList(new User("Jeff", "Mills","jf@gmail.com"),
                new User("Carl", "Cox","cc@gmail.com"));
        return users;
    }

}

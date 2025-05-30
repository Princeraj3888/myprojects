package com.exploretechs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping
    public String index(Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "index";
    }

    @GetMapping("/ott/sent")
    public String sentOtt(){
        return "ott-sent";
    }
}

package com.monograph.railway.railwayreservationmysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contcat() {
        return "contact";
    }
    @GetMapping("/service")
    public String service() {
        return "service";
    }
    @GetMapping("/train")
    public String searchTrain() {
        return "train";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/station")
    public String station() {
        return "station";
    }
}
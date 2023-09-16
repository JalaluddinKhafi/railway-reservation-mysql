package com.monograph.railway.railwayreservationmysql.controller;

import com.monograph.railway.railwayreservationmysql.ServiceImpl.UserServiceImpl;
import com.monograph.railway.railwayreservationmysql.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserServiceImpl userServicImpl;

    public UserController(UserServiceImpl userServicImpl) {
        this.userServicImpl = userServicImpl;
    }
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
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/saveUser")
    public String registerUser(@ModelAttribute("user") User user) {
        userServicImpl.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/user-home")
    public String userHome() {
        return "user-home";
    }

    @GetMapping("/schedule")
    public String schedule() {
        return "schedule";
    }

    @GetMapping("/view-all-stations")
    public String station() {
        return "view-all-stations";
    }

    @GetMapping("/view-all-tickets")
    public String allTickets() {
        return "view-all-tickets";
    }

    @GetMapping("/view-all-trains")
    public String allTrains() {
        return "view-all-trains";
    }


}
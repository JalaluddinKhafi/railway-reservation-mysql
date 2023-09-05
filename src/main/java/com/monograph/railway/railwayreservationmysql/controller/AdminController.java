package com.monograph.railway.railwayreservationmysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin-home")
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping("/admin-add-train")
    public String addTrain() {
        return "admin-add-train";
    }

    @GetMapping("/add-station")
    public String addStation() {
        return "add-station";
    }

    @GetMapping("/admin-all-tickets")
    public String allTickets() {
        return "admin-all-tickets";
    }

    @GetMapping("/admin-all-trains")
    public String allTrains() {
        return "admin-all-trains";
    }

    @GetMapping("/view-all-users")
    public String allUsers() {
        return "view-all-users";
    }

    @GetMapping("/add-schedule")
    public String addSchedule() {
        return "add-schedule";
    }
}

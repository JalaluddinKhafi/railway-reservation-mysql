package com.monograph.railway.railwayreservationmysql.controller;

import com.monograph.railway.railwayreservationmysql.ServiceImpl.RouteServiceImpl;
import com.monograph.railway.railwayreservationmysql.ServiceImpl.TrainStatusServiceImpl;
import com.monograph.railway.railwayreservationmysql.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    TrainStatusServiceImpl trainStatusService;
    @Autowired
    RouteServiceImpl routeService;
    @GetMapping("/guestTrains")
    public String getAllTriansDetials(Model model){
        List<Object[]> trainDetails=trainStatusService.getTrainDetails();
        model.addAttribute("trainDetails",trainDetails);
        return "guestTrains";

    }
    @GetMapping("/guestRouts")
    public String getAllRoutes(Model model){
        List<Route> routes=routeService.getAllRoutes();
        model.addAttribute("allRoutes",routes);
        return "guestRouts";
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
}

package com.monograph.railway.railwayreservationmysql.controller;

import com.monograph.railway.railwayreservationmysql.ServiceImpl.RouteServiceImpl;
import com.monograph.railway.railwayreservationmysql.ServiceImpl.TrainServiceImpl;
import com.monograph.railway.railwayreservationmysql.ServiceImpl.TrainStatusServiceImpl;
import com.monograph.railway.railwayreservationmysql.model.Route;
import com.monograph.railway.railwayreservationmysql.model.Train;
import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class trainController {
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

}

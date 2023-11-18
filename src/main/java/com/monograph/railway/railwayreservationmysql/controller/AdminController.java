package com.monograph.railway.railwayreservationmysql.controller;

import com.monograph.railway.railwayreservationmysql.ServiceImpl.*;
import com.monograph.railway.railwayreservationmysql.model.*;
import com.monograph.railway.railwayreservationmysql.repository.TrainStatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final RouteServiceImpl routeService;
    private final UserServiceImpl userService;

    private final TrainServiceImpl trainService;
    private final TrainStatusServiceImpl trainStatusService;
    private final PassengerServiceImpl passengerService;
    private final TicketServiceImpl ticketService;
    private final TrainStatusRepository trainStatusRepository;

    public AdminController(RouteServiceImpl routeService, UserServiceImpl userServicImpl, TrainServiceImpl trainService, TrainStatusServiceImpl trainStatusService, PassengerServiceImpl passengerService, TicketServiceImpl ticketService, TrainStatusRepository trainStatusRepository) {
        this.routeService = routeService;
        this.userService = userServicImpl;
        this.trainService = trainService;
        this.trainStatusService = trainStatusService;
        this.passengerService = passengerService;
        this.ticketService = ticketService;
        this.trainStatusRepository = trainStatusRepository;
    }


    @GetMapping("/adminHomePage")
    public String adminHome() {
        return "adminPages/adminHomePage";
    }

    @GetMapping("/admin_all_trains")
    public String showTrains(Model model) {
        List<Train> allTrains = trainService.getAllTrains();
        model.addAttribute("allTrains", allTrains);

        return "adminPages/admin_all_trains";
    }

    @GetMapping("/admin_all_routes")
    public String allRoutes(Model model) {
        List<Route> routeList = routeService.getAllRoutes();
        model.addAttribute("route", routeList);

        return "adminPages/admin_all_routes";
    }

    @GetMapping("/tickets")
    public String allTickets(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);

        return "adminPages/tickets";
    }

    @GetMapping("/passengers")
    public String allTrains(Model model) {
        List<Passenger> passengers = passengerService.getAllPassengers();
        model.addAttribute("passengers", passengers);

        return "adminPages/passengers";
    }

    @GetMapping("/users")
    public String allUsers(Model model) {
        List<User> userList=userService.getAllUsers();
        model.addAttribute("users",userList);

        return "adminPages/users";
    }

    @GetMapping("/schedule")
    public String getSchedule(Model model) {
        List<TrainStatus> schedules = trainStatusService.getAllTrainStatuses();
        model.addAttribute("schedules", schedules);
        return "adminPages/schedule";
    }

    @Transactional
    @GetMapping("/deleteSchedule/{id}")
    public String deleteSchedule(@PathVariable long id) {
        try {
            System.out.println("trainStatus deleted!!" +" "+id);
            trainStatusRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error deleting Train Status with ID: {} " + id + " " + e);
            // Log the exception or rethrow if needed
        }
        return "redirect:/admin/schedule";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id) {
        System.out.println("user deleted!!" +" "+id);
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

}

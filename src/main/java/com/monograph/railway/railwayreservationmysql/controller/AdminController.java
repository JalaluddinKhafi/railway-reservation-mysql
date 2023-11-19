package com.monograph.railway.railwayreservationmysql.controller;

import com.monograph.railway.railwayreservationmysql.ServiceImpl.*;
import com.monograph.railway.railwayreservationmysql.model.*;
import com.monograph.railway.railwayreservationmysql.repository.TrainStatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    //add route to the database
    @GetMapping("/routeForm")
    public String showFormToAddRoute(Model model){
        model.addAttribute("route",new Route());
        return "adminPages/add_route";
    }
    @PostMapping("/addRoute")
    public String addRoute(@ModelAttribute Route route){
        routeService.saveRoute(route);
        return "redirect:/admin/admin_all_routes";
    }
    @GetMapping("/trainForm")
    public String showTrainForm(Model model){
        model.addAttribute("train",new Train());
        return "adminPages/add_train";
    }
    @PostMapping("/addTrain")
    public String addTrain(@ModelAttribute Train train){
        trainService.saveTrain(train);
        return "redirect:/admin/admin_all_trains";
    }
    @GetMapping("/scheduleForm")
    public String showScheduleForm(Model model){
        List<Train> trains=trainService.getAllTrains();
        model.addAttribute("trains",trains);
        List<Route> routes=routeService.getAllRoutes();
        model.addAttribute("routes",routes);
        model.addAttribute("trainStatus",new TrainStatus());
        return "adminPages/add_schedule";
    }

    @PostMapping("/addSchedule")
    public String saveSchedule(@ModelAttribute TrainStatus trainStatus,Model model) {

        // Get the selected Buss based on the bussId from the form
        long trainId = trainStatus.getTrain().getId();
        Long routeId=trainStatus.getRoute().getId();
        Train selectedTrain = trainService.getTrainById(trainId);
        Route selectedRoute =routeService.getRouteById(routeId);
        boolean scheduleExists = trainStatusService.existsByTrainId(trainId);
        if (selectedTrain != null && selectedRoute != null && !scheduleExists) {
            System.out.println("the id is:" + selectedTrain.getId());
            trainStatus.setTrain(selectedTrain);
            trainStatusService.saveTrainStatus(trainStatus);
            return "redirect:/admin/schedule";

        } else {
            model.addAttribute("trains", trainService.getAllTrains());
            model.addAttribute("routes", routeService.getAllRoutes());
            model.addAttribute("trainStatus", trainStatus);
            System.out.println("error to use already bus");
            // Schedule with the same buss_id already exists, add an error message
            model.addAttribute("error", "A schedule for this Train already exists.");
            return "adminPages/add_schedule";
        }

    }



}

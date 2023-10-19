package com.monograph.railway.railwayreservationmysql.controller;

import com.monograph.railway.railwayreservationmysql.ServiceImpl.RouteServiceImpl;
import com.monograph.railway.railwayreservationmysql.ServiceImpl.TrainServiceImpl;
import com.monograph.railway.railwayreservationmysql.ServiceImpl.TrainStatusServiceImpl;
import com.monograph.railway.railwayreservationmysql.ServiceImpl.UserServiceImpl;
import com.monograph.railway.railwayreservationmysql.model.Route;
import com.monograph.railway.railwayreservationmysql.model.Train;
import com.monograph.railway.railwayreservationmysql.model.TrainStatus;
import com.monograph.railway.railwayreservationmysql.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @ModelAttribute
    public void addAttributes(Model model, HttpSession session) {
        String firstName = (String) session.getAttribute("firstName");
        String lastName = (String) session.getAttribute("lastName");
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        String username = (String) session.getAttribute("username");
        Long id = (Long) session.getAttribute("id");
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        model.addAttribute("username", username);
        model.addAttribute("id",id);
        //model.addAttribute("id", id);
    }
    private final RouteServiceImpl routeService;
    private final UserServiceImpl userService;

    private final TrainServiceImpl trainService;
    private final TrainStatusServiceImpl trainStatusService;
    public UserController(RouteServiceImpl routeService, UserServiceImpl userServicImpl, TrainServiceImpl trainService, TrainStatusServiceImpl trainStatusService) {
        this.routeService = routeService;
        this.userService = userServicImpl;
        this.trainService = trainService;
        this.trainStatusService = trainStatusService;
    }
    @GetMapping("/createAccount")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "createAccount";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model)
    {
        User existingUser= userService.findByUsername(user.getUsername());
       if (existingUser !=null){
            model.addAttribute("errorMessage","Username is already in use");
            return "createAccount";
        }

        // Check if email already exists
        User existingEmailUser = userService.findByEmail(user.getEmail());
        if (existingEmailUser != null) {
            model.addAttribute("errorMessage", "Email is already in use");
            return "createAccount";
        }

        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        RedirectAttributes attributes,
                        HttpSession session){

        User user = userService.findByUsername(username);
        if (user !=null && user.getPassword().equals(password)){
            session.setAttribute("firstName",user.getFirstName());
            session.setAttribute("lastName",user.getLastName());
            session.setAttribute("email",user.getEmail());
            session.setAttribute("password",user.getPassword());
            session.setAttribute("username",user.getUsername());
            session.setAttribute("id",user.getId());

            return "redirect:/userHomePage";
        }else {
            attributes.addAttribute("error","Invalid username or password");
            return "redirect:/login";

        }
    }


    @GetMapping("/userHomePage")
    public String userHome(HttpSession session, Model model) {
        String firstName=(String) session.getAttribute("firstName");
        String lastName=(String) session.getAttribute("lastName");
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        System.out.println("welcome "+firstName+" "+ lastName);
        return "userPages/userHomePage";
    }

    @GetMapping("/user_all_routes")
    public String allRoutes(Model model) {
        List<Route> routeList=routeService.getAllRoutes();
        model.addAttribute("route",routeList);
        return "userPages/user_all_routes";
    }



    @GetMapping("/user_all_trains")
    public String allTrains(Model model) {
        List<Train> allTrains=trainService.getAllTrains();
        model.addAttribute("allTrains",allTrains);
        return "userPages/user_all_trains";
    }

    @GetMapping("/userProfile")
    public String profile(){
        return "userPages/userProfile";
    }
    @RequestMapping("/userEdite/{id}")
    public String showUpdateTableUser(@PathVariable("id") long id,Model model){
        User user=userService.getUserById(id);
        model.addAttribute("user",user);
        return "userPages/userEdite";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        // Update the user details in the database
        userService.saveUser(user);
        return "redirect:/userProfile";
    }
    @GetMapping("/schedule")
    public String getSchedule(Model model) {
        List<TrainStatus> schedules = trainStatusService.getAllTrainStatuses();
        model.addAttribute("schedules", schedules);
        return "userPages/schedule";
    }
    @GetMapping("/passengerTickets")
    public String allTickets() {
        return "userPages/passengerTickets";
    }


}
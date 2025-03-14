package com.adeleke.flyroamer.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.adeleke.flyroamer.model.User;
import com.adeleke.flyroamer.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // Display all users (for debugging)
    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users_list";
    }

    // Show form to register a new user
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";  // Ensure this template exists as "register.html"
    }

    // Handle user registration (without security)
//    @PostMapping("/register")
//    public String registerUser(@RequestParam(required = false) String username,
//                               @RequestParam String email,
//                               @RequestParam String password) {
//        User user = new User();
//        user.setUsername(username);
//        user.setEmail(email);
//        user.setPassword(password);
//        userService.saveUser(user);
//        return "redirect:/users/login";
//    }

//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute User user, Model model) {
//        try {
//            userService.saveUser(user);
//            return "redirect:/users/login";  // Redirect to login after success
//        } catch (RuntimeException e) {
//            model.addAttribute("error", "Email is already in use. Please use a different email.");
//            return "register";  // Stay on the registration page and show the error
//        }}

    @PostMapping("/register")
    public String registerUser(@RequestParam(required = true ) String username,
                               @RequestParam String email,
                               @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        userService.saveUser(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";  // Ensure this template exists as "register.html"
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        Optional<User> user = userService.loginUser(email, password);
        if (user.isPresent()) {
            return "redirect:/trips";  // Redirect to home page after login
        } else {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }


    }
}



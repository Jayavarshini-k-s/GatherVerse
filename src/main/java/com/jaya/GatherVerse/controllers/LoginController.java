package com.jaya.GatherVerse.controllers;

import com.jaya.GatherVerse.data.UserRepository;
import com.jaya.GatherVerse.models.LoginModel;
import com.jaya.GatherVerse.models.User;
import com.jaya.GatherVerse.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String displayLoginOptions() {
        return "login"; // Your HTML file (login.html)
    }

    @GetMapping("/form")
    public String displayLoginForm(@RequestParam("role") String role, Model model) {
        LoginModel loginModel = new LoginModel();
        loginModel.setRole(role); // Set the role based on selection
        model.addAttribute("loginModel", loginModel);
        return "loginForm.html";
    }

    @PostMapping("/processLogin")
    public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("Error");
            model.addAttribute("loginModel", loginModel);
            return "loginForm.html";
        }

        String role = loginModel.getRole(); // Get role (admin or student)
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();

        // Validate credentials
        boolean isValidUser = userService.validateUserCredentials(username, password, role);

        if (!isValidUser) {
            model.addAttribute("errorMessage", "Invalid username or password."); // Set error message
            model.addAttribute("loginModel", loginModel); // Keep the entered data
            return "loginForm"; // Return to the login form with an error message
        }

        // If valid user, redirect based on role
        if ("admin".equals(role)) {
            return "redirect:/orders/admin"; // Redirect to the admin dashboard
        } else if ("student".equals(role)) {
            return "redirect:/orders/student"; // Redirect to the student dashboard
        } else {
            model.addAttribute("error", "Invalid role");
            return "loginForm"; // Show error in login form
        }
    }
}
package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping({"/login", "/signin"})
    public String showLogin() {
        return "signinView";
    }

    @GetMapping({"/signout", "/logout"})
    public String showLogout() {
        return "signoutView";
    }

    @GetMapping("/accessError")
    public String accessError() {
        return "accessError";
    }
}

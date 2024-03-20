package com.example.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping({"/", "/index"})
    public String showMain() {
        return "indexView";
    }

    @GetMapping({"/accessError"})
    public String showError() {
        return "accessError";
    }
}


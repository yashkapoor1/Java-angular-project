package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class webcontroller {

    @GetMapping("/")
    public String home() {
        return "index"; // Looks directly for index.html inside /templates/
    }
}
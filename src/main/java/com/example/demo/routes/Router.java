package com.example.demo.routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Router {

    @GetMapping
    public String getHome() {
        return "Home";
    }
}

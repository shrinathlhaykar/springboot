package com.olsproject.onlinelotterysystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String message(){
        return "Welcome to Online Lottery System Try your Luck!!!!!!";
    }
}

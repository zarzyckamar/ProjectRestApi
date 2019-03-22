package com.Project.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:8080")
public class First {


    @RequestMapping("/status/ping")
    String Pong() {
        return "pong";
    }


}

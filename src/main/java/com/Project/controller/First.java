package com.Project.controller;


import org.apache.catalina.connector.Response;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:8080")
public class First {


    @RequestMapping("/status/ping")
    String Pong() {
        return "pong";
    }


}

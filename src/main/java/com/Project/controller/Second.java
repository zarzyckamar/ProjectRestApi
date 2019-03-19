package com.Project.controller;

import com.Project.model.SecondModel;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:8080")

public class Second {

    @RequestMapping(value = "/numbers/sort-command", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    SecondModel secondModel(@RequestParam List numbers, @RequestParam String order) {

            switch (order) {
                case "ASC":
                    Collections.sort(numbers);
                    break;
                case "DESC":
                    Collections.sort(numbers, Collections.reverseOrder());
                    break;
                default:
                    return new SecondModel(Collections.singletonList(HttpStatus.BAD_REQUEST));
            }

            return new SecondModel(numbers);
        }


}

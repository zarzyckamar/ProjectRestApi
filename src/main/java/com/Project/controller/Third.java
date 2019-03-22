package com.Project.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.annotate.JsonIgnore;
import org.json.HTTP;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.URL;

@RestController
@EnableAutoConfiguration
@CrossOrigin(origins = "http://localhost:8080")

public class Third {

    @RequestMapping(value = "/currencies/get-current-currency-value-command", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    Object thirdModel(@RequestParam String codeValue) throws IOException {

        File file = new File("C:/Users/Admin/Downloads/Project/odp.json");
        JSONParser parser = new JSONParser();
        BufferedInputStream in = new BufferedInputStream(new URL("http://api.nbp.pl/api/exchangerates/tables/A?format=json").openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {

            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }

        try {
            FileReader reader = new FileReader("C:/Users/Admin/Downloads/Project/odp.json");
            Object obj = parser.parse(reader);
           /* JSONArray rates = (JSONArray) obj;
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray rates = (JSONArray) jsonObject.get("rates");
            return rates;
             */

            return obj;
        }
                /*String namecurrency = (String) jsonObject.get("currency");

                String code = (String) jsonObject.get("code");

                Double mid = (Double) jsonObject.get("mid");

                if (code.equals(codeValue)){
                   return mid;
                }
                else return HttpStatus.BAD_REQUEST;


*/ catch (ParseException e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }

    }
}



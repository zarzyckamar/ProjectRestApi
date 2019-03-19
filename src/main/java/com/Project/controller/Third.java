package com.Project.controller;


import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

@RestController
public class Third {

    @RequestMapping(value = "/currencies/get-current-currency-value-command", method ={ RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    JSONArray thirdModel(@RequestParam String codeValue) throws IOException {
        File file = new File("C:/Users/Admin/Downloads/Project/odp.txt");
        try (BufferedInputStream in = new BufferedInputStream(new URL("http://api.nbp.pl/api/exchangerates/tables/A?format=json").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            try (FileReader reader = new FileReader("C:/Users/Admin/Downloads/Project/odp.txt")) {
                Object obj = new JSONParser(reader);

                JSONObject jsonObject = new JSONObject();

                JSONArray valueList = (JSONArray) jsonObject.get("mid");


                String namecurrency = (String) jsonObject.get("currency");

                String code = (String) jsonObject.get("code");

                Double mid = (Double) jsonObject.get("mid");

                if (codeValue.equals("EUR")){
                    return valueList;
                }
                return valueList;
            }


        } catch (IOException e) {
            // handle exception
            return null;
        }

    }

}

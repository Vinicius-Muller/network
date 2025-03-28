package com.example.network.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping
    public String sayHi(@RequestParam(value = "date", required = false) String date) {
        if (date != null) {
            logger.info("Received date: " + date);
        } else {
            logger.info("No date provided");
        }

        try {
            URL url = new URL("http://localhost:8080/api/auth");
            logger.info("Protocol: " + url.getProtocol());
        } catch (MalformedURLException e) {
            logger.error("Invalid URL: " + e.getMessage());
        }

        return "Hello Worlds";
    }
}

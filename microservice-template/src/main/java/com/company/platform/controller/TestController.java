package com.company.platform.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.platform.exception.ApiException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class TestController {
    private static final Logger log =
        LoggerFactory.getLogger(TestController.class);
    
    @GetMapping("/api/test")
    public String test() {
        log.info("Test API called");
        return "JWT OK";
    }
    @GetMapping("/api/error")
    public String error() {
        throw new ApiException("Something went wrong", 400);
    }
}
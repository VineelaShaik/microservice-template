package com.company.platform.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.platform.exception.ApiException;

@RestController
public class TestController {

    @GetMapping("/api/test")
    public String test() {
        return "JWT OK";
    }
    @GetMapping("/api/error")
    public String error() {
        throw new ApiException("Something went wrong", 400);
    }
}
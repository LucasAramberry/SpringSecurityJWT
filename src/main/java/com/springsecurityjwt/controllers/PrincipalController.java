package com.springsecurityjwt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PrincipalController {

    @GetMapping("/hello")
    public String helloSecured(){
        return "hello world not secured";
    }

    @GetMapping("/helloSecured")
    public String hello(){
        return "hello world secured";
    }
}

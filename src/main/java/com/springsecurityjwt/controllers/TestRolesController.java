package com.springsecurityjwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestRolesController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/accessAdmin")
    public String accessAdmin() {
        return "Hello, you have accessed with role ADMIN";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/accessUser")
    public String accessUser() {
        return "Hello, you have accessed with role USER";
    }

    @PreAuthorize("hasRole('INVITED')")
    @GetMapping("/accessInvited")
    public String accessInvited() {
        return "Hello, you have accessed with role INVITED";
    }
}

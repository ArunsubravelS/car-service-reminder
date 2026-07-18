package com.carservice.user.controller;

import com.carservice.user.dto.LoginRequest;
import com.carservice.user.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return service.login(request);

    }

}
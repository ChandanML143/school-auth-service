package com.school.auth_service.controller;

import com.school.auth_service.dto.LoginRequest;
import com.school.auth_service.model.User;
import com.school.auth_service.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        return authService.login(request);

    }
}

package com.school.auth_service.service;

import com.school.auth_service.dto.LoginRequest;
import com.school.auth_service.model.User;
import com.school.auth_service.repository.UserRepository;
import com.school.auth_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public String login(LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(!user.getPassword().equals(request.getPassword())){
            throw new RuntimeException("Invalid password");
        }
        return jwtUtil.generateToken(user.getUsername(), user.getRole().name());
    }
}

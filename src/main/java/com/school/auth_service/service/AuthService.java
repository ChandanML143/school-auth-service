package com.school.auth_service.service;

import com.school.auth_service.dto.LoginRequest;

public interface AuthService {

    String login(LoginRequest request);

}

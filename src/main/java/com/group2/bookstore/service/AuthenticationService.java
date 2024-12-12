package com.group2.bookstore.service;

import com.group2.bookstore.dto.request.LoginRequest;
import com.group2.bookstore.dto.request.RegisterRequest;
import com.group2.bookstore.dto.response.JwtAuthResponse;

public interface AuthenticationService {
    JwtAuthResponse login(LoginRequest loginRequest);

    JwtAuthResponse refreshToken(String refreshToken);

    String register(RegisterRequest registerRequest);
}

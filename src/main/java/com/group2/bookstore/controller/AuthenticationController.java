package com.group2.bookstore.controller;

import com.group2.bookstore.dto.request.LoginRequest;
import com.group2.bookstore.dto.request.RegisterRequest;
import com.group2.bookstore.dto.response.JwtAuthResponse;
import com.group2.bookstore.service.AuthenticationService;
import com.group2.bookstore.service.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication API")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    @Operation(summary = "Login", description = "Login API")
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login (@RequestBody @Valid LoginRequest loginRequest){
        JwtAuthResponse authenticationUser =  authenticationService.login(loginRequest);

        return ResponseEntity.ok(authenticationUser);
    }

    @Operation(summary = "Register", description = "Register API")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequest registerRequest){
        String response = authenticationService.register(registerRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
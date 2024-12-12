package com.group2.bookstore.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String fullName;
    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    @NotBlank(message = "Username is required")
    private String username;
    private String email;
    @NotNull(message = "Password is required")
    @NotBlank(message = "Password is required")
    @NotEmpty(message = "Password is required")
    private String password;

}
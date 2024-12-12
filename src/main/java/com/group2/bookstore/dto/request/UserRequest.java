package com.group2.bookstore.dto.request;

import com.group2.bookstore.entity.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    @NotBlank(message = "Username is required")
    private String username;
    @NotEmpty(message = "Password is required")
    @NotBlank(message = "Password is required")
    @NotNull(message = "Password is required")
    private String password;
    private String email;
    private String fullName;
    private Set<Role> roles;
}

package com.group2.bookstore.dto.response;

import com.group2.bookstore.entity.Role;
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
    private Long userId;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private Set<Role> roles;
}

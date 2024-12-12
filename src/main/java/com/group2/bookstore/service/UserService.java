package com.group2.bookstore.service;


import com.group2.bookstore.dto.request.UserRequest;
import com.group2.bookstore.dto.response.PageCustom;
import com.group2.bookstore.dto.response.UserResponse;
import com.group2.bookstore.entity.User;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResponse getUserById(Long userId);

    PageCustom<UserResponse> getAllUser(Pageable pageable);

    UserResponse updateUser(Long userId, UserRequest userRequest);

    String deleteUser(Long userId);
}

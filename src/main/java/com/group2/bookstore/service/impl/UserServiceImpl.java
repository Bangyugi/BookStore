package com.group2.bookstore.service.impl;

import com.group2.bookstore.dto.request.UserRequest;
import com.group2.bookstore.dto.response.PageCustom;
import com.group2.bookstore.dto.response.UserResponse;
import com.group2.bookstore.entity.Role;
import com.group2.bookstore.entity.User;
import com.group2.bookstore.exception.AppException;
import com.group2.bookstore.exception.ErrorCode;
import com.group2.bookstore.exception.ResourceNotFoundException;
import com.group2.bookstore.repository.RoleRepository;
import com.group2.bookstore.repository.UserRepository;
import com.group2.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    @Override
    public UserResponse getUserById(Long userId) {

            User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
            UserResponse userResponse =  modelMapper.map(user, UserResponse.class);
            return userResponse;

    }


    @Override
    public PageCustom<UserResponse> getAllUser(Pageable pageable) {

            Page<User> page = userRepository.findAll(pageable);
            PageCustom<UserResponse> pageCustom = PageCustom.<UserResponse>builder()
                    .pageNo(page.getNumber() + 1)
                    .pageSize(page.getSize())
                    .totalPages(page.getTotalPages())
                    .pageContent(page.getContent().stream().map(user->modelMapper.map(user, UserResponse.class)).toList())
                    .build();

            return pageCustom;

    }

    @Override
    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        if (!userRequest.getUsername().equals(user.getUsername())){
            throw new AppException(ErrorCode.User_NAME_CAN_NOT_BE_CHANGED);
        }
        modelMapper.map(userRequest,user);
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return modelMapper.map(userRepository.save(user),UserResponse.class);
    }

    @Override
    public String deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        userRepository.delete(user);
        return "User with id: " +userId+ " was deleted successfully";
    }
}

package com.dayoungapplication.controller;

import java.util.List;

import com.dayoungapplication.dto.response.UserResponse;
import com.dayoungapplication.repository.UserRepository;
import jakarta.validation.Valid;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.dayoungapplication.dto.request.ApiResponse;
import com.dayoungapplication.dto.request.UserCreationRequest;
import com.dayoungapplication.dto.request.UserUpdateRequest;
import com.dayoungapplication.entity.User;
import com.dayoungapplication.service.UserService;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;
    private final UserRepository userRepository;

    @GetMapping

    public ApiResponse<List<UserResponse>> listUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}",authentication.getName());
        log.info("Roles: {}", authentication.getAuthorities());
        return ApiResponse.<List<UserResponse>>builder().result(userService.getAllUsers()).build();
    }

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.createUser(request));
        return response;
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }
}

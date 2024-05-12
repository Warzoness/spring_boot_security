package com.dayoungapplication.service;

import java.util.HashSet;
import java.util.List;

import com.dayoungapplication.dto.response.UserResponse;
import com.dayoungapplication.enums.Role;
import com.dayoungapplication.exception.AppException;
import com.dayoungapplication.exception.ErrorCode;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.dayoungapplication.dto.request.UserCreationRequest;
import com.dayoungapplication.dto.request.UserUpdateRequest;
import com.dayoungapplication.entity.User;
import com.dayoungapplication.mapper.UserMapper;
import com.dayoungapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;


    // Tạo mới người dùng
    public User createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    //Lấy danh sách người dùng
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).toList();
    }

    // Lấy người dùng theo Id
    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not" +
                " Found")));
    }

    // Sửa thông tin người dùng
    public UserResponse updateUser(String id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }


    // Xóa người dùng
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

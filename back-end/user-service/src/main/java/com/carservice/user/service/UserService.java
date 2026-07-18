package com.carservice.user.service;

import com.carservice.user.dto.RegisterRequest;
import com.carservice.user.dto.UserResponse;
import com.carservice.user.entity.User;
import com.carservice.user.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository,
                       PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse register(RegisterRequest request) {

        if(repository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());

        // Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User saved = repository.save(user);

        UserResponse response = new UserResponse();

        response.setId(saved.getId());
        response.setFullName(saved.getFullName());
        response.setEmail(saved.getEmail());

        return response;
    }

}
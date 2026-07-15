package com.carservice.user.service;

import com.carservice.user.dto.RegisterRequest;
import com.carservice.user.dto.UserResponse;
import com.carservice.user.entity.User;
import com.carservice.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository = null;

    public UserResponse register(RegisterRequest request){

        if(repository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists");
        }

        User user=new User();
        user.setId(request.getId());
        user.setEmail(request.getEmail());
        user.setFullName(request.getFullName());
        user.setPassword(request.getPassword());
        
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());

        return response;
    }

}
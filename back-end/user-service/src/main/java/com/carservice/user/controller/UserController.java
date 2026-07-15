package com.carservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carservice.user.dto.RegisterRequest;
import com.carservice.user.dto.UserResponse;
import com.carservice.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
	
	
	private final UserService service = null;
	
	  @PostMapping("/register")
	    public UserResponse register(@RequestBody RegisterRequest request){

			return service.register(request);
}

}
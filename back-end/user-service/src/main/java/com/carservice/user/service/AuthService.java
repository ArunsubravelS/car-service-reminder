	package com.carservice.user.service;
	
	import com.carservice.user.dto.LoginRequest;
	import com.carservice.user.entity.User;
	import com.carservice.user.repository.UserRepository;
	
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.stereotype.Service;
	
	@Service
	public class AuthService {
	
	    private final UserRepository repository;
	    private final PasswordEncoder passwordEncoder;
	
	    public AuthService(UserRepository repository,
	                       PasswordEncoder passwordEncoder) {
	        this.repository = repository;
	        this.passwordEncoder = passwordEncoder;
	    }
	
	    public String login(LoginRequest request) {
	
	        User user = repository.findByEmail(request.getEmail())
	                .orElseThrow(() ->
	                        new RuntimeException("User not found"));
	
	        if(passwordEncoder.matches(request.getPassword(),
	                user.getPassword())) {
	
	            return "Login Successful";
	
	        }
	
	        return "Invalid Password";
	
	    }
	
	}
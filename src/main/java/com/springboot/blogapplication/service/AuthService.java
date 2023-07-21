package com.springboot.blogapplication.service;

import com.springboot.blogapplication.payload.LoginDto;
import com.springboot.blogapplication.payload.RegisterDto;

public interface AuthService {

	String login(LoginDto loginDto);
	
	String register(RegisterDto registerDto);
}

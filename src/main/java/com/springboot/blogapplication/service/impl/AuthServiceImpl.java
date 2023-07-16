package com.springboot.blogapplication.service.impl;

import java.util.Set;
import java.util.HashSet;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.blogapplication.entity.User;
import com.springboot.blogapplication.entity.Role;
import com.springboot.blogapplication.exception.BlogAPIException;
import com.springboot.blogapplication.payload.LoginDto;
import com.springboot.blogapplication.payload.RegisterDto;
import com.springboot.blogapplication.repository.RoleRepository;
import com.springboot.blogapplication.repository.UserRepository;
import com.springboot.blogapplication.security.JwtTokenProvider;
import com.springboot.blogapplication.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService{

	private AuthenticationManager authenticationManager;
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	private JwtTokenProvider jwtTokenProvider;
	
	public AuthServiceImpl(AuthenticationManager authenticationManager,
							UserRepository userRepository,
							RoleRepository roleRepository,
							PasswordEncoder passwordEncoder,
							JwtTokenProvider jwtTokenProvider) {
		super();
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	public String login(LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				loginDto.getUsernameOrEmail(), loginDto.getPassword()));
		
		//store Authentication object into spring security context holder
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);
		return token;
	}

	@Override
	public String register(RegisterDto registerDto) {
		//checks for user exists in database
		if(userRepository.existsByUsername(registerDto.getUsername())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Username already exists!");
		}
		
		//checks for email exists in database
		if(userRepository.existsByEmail(registerDto.getEmail())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Email already exists!");
		}
		
		User user = new User();
		user.setName(registerDto.getName());
		user.setUsername(registerDto.getUsername());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName("ROLE_USER").get();
		roles.add(userRole);
		user.setRoles(roles);
		
		userRepository.save(user);
		return "User registered successfully!";
	}

}

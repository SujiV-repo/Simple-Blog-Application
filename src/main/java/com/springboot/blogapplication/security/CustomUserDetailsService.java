package com.springboot.blogapplication.security;


import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;

import com.springboot.blogapplication.repository.UserRepository;
import com.springboot.blogapplication.entity.User;
import java.util.Set;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	
	private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	//database authentication
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
			.orElseThrow(() -> 
			new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));
		
		//converting set of roles to set of granted authorities
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		
		//converting user object into Spring security provided user object
		return new org.springframework.security.core.userdetails.User(user.getEmail(), 
				user.getPassword(), 
				authorities);
	}

}

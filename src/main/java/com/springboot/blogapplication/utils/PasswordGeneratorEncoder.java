package com.springboot.blogapplication.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//This class is used only to get the authenticated password to store it in database to test the database authentication
//In database password is stored as plainobject, 
//we are encoding the password and passing it to this class to encode the password
public class PasswordGeneratorEncoder {

	public static void main(String[] args) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("admin"));
		System.out.println(passwordEncoder.encode("Robin"));
	}
}

package com.springboot.blogapplication.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {
	
	private long id;
	
	//name should not be null or empty
	@NotEmpty(message = "Name should not be null or empty")
	private String name;
	
	//email should not be null or empty and email field validation
	@NotEmpty(message = "Email should not be null or empty")
	@Email
	private String email;
	
	//comment body should not be null or empty and should contain atleast 10 characters
	@NotEmpty
	@Size(min = 10, message = "comment body should be atleast 10 characters")
	private String body;
}

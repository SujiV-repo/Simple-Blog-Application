package com.springboot.blogapplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot BlogApplication",
				description = "Blog Application REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Sujith"
						//email
						//url = ""
				),
				license = @License(
						name = "Apache 2.0"
						//url = 
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Blog Application Documentation built using Spring Boot"
				//url- add github repository
		)
)
public class SpringBootBlogApplicationApiApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogApplicationApiApplication.class, args);
	}

}

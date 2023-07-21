package com.springboot.blogapplication.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blogapplication.payload.PostDto;
import com.springboot.blogapplication.payload.PostResponse;
import com.springboot.blogapplication.service.PostService;
import com.springboot.blogapplication.utils.AppConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
@Tag(
		name = "CRUD REST APIs for the Post Resources"
)
public class PostController {
	
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	
	//create blog post
	//Admin has create access
	@Operation(
			summary = "Create Post REST API",
			description = "Create Post REST API is used to save a post into the database"
	)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 CREATED"
	)
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
		return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
	}
	
	//get all posts
	@Operation(
			summary = "Get All Posts REST API",
			description = "Get all Posts REST API is used to fetch all the posts from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 SUCCESS"
	)
	@GetMapping
	public PostResponse getAllPosts(
			//requesting query parameters for the page number and for the page size to provide pagination
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
	){
		return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
	}
	
	//get post by id
	@Operation(
			summary = "Get Post By Id REST API",
			description = "Get Post by Id REST API is used to get a single post from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 SUCCESS"
	)
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
		return ResponseEntity.ok(postService.getPostById(id));
	}
	
	//update post by id
	//Admin has update access
	@Operation(
			summary = "Update Post REST API",
			description = "Update Post REST API is used to update a particular post from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 SUCCESS"
	)
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable(name = "id") long id){
		PostDto postResponse = postService.updatePost(postDto, id);
		return new ResponseEntity<>(postResponse, HttpStatus.OK);
	}
	
	//delete post by id
	//admin has delete access
	@Operation(
			summary = "Delete Post REST API",
			description = "Delete Post REST API is used to delete a particular post from the database"
	)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 SUCCESS"
	)
	@SecurityRequirement(
			name = "Bearer Authentication"
	)
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id){
		postService.deletePostById(id);
		return new ResponseEntity<>("Post Entity deleted successfully", HttpStatus.OK);
	}
	
	//Build get posts by Category Rest API
	@GetMapping("/category/{id}")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable(value = "id")long categoryId){
		List<PostDto> postDtos = postService.getPostByCategory(categoryId);
		return ResponseEntity.ok(postDtos);
	}
}

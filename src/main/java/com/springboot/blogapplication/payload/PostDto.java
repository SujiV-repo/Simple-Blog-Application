package com.springboot.blogapplication.payload;

import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
		description = "PostDto Model Information"
)
public class PostDto {
	private long id;
	
	//title should not be null or empty, must have atleast two characters
	@Schema(
			description = "Blog Post Title"
	)
	@NotEmpty
	@Size(min = 2, message = "Post title should have atleast two characters")
	private String title;
	
	//description should not be null or empty, must have atleast 10 characters
	@Schema(
			description = "Blog Post Description"
	)
	@NotEmpty
	@Size(min = 10, message = "Post Description should have atleast ten characters")
	private String description;
	
	//Post content should not be null or empty
	@Schema(
			description = "Blog Post Content"
	)
	@NotEmpty
	private String content;
	
	private Set<CommentDto> comments;
	
	@Schema(
			description = "Blog Post Category"
	)
	private long categoryId;
}

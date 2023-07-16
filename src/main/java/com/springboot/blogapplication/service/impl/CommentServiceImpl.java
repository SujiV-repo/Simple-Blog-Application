package com.springboot.blogapplication.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blogapplication.entity.Comment;
import com.springboot.blogapplication.entity.Post;
import com.springboot.blogapplication.exception.BlogAPIException;
import com.springboot.blogapplication.exception.ResourceNotFoundException;
import com.springboot.blogapplication.payload.CommentDto;
import com.springboot.blogapplication.repository.CommentRepository;
import com.springboot.blogapplication.repository.PostRepository;
import com.springboot.blogapplication.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	private CommentRepository commentRepository;
	private PostRepository postRepository;
	private ModelMapper mapper;
	
	public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper mapper) {
		super();
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
		this.mapper = mapper;
	}

	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {
		
		Comment comment = mapToEntity(commentDto);
		
		//retrieve post entity by id
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		
		//set post to comment entity
		comment.setPost(post);
		
		//save comment entity to database
		Comment newComment = commentRepository.save(comment);
		
		return mapToDto(newComment);
	}
	
	@Override
	public List<CommentDto> getCommentsByPostId(long postId) {
		// Retrieve comments by Post Id
		List<Comment> comments = commentRepository.findByPostId(postId);
		
		//converting list of comment entities to list of comment Dtos
		return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
	}
	
	@Override
	public CommentDto getCommentById(long postId, long commentId) {
		//retrieve post entity by id
		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		
		//retrieve comment entity by id
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));
		
		if(!comment.getPost().getId().equals(post.getId())){
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "comment does not belong to post");
		}
		
		return mapToDto(comment);
	}
	
	@Override
	public CommentDto updateComment(long postId, long commentId, CommentDto commentRequest) {
		//retrieve post entity by id
		Post post = postRepository.findById(postId)
						.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
		
		//retrieve comment entity by id
		Comment comment = commentRepository.findById(commentId)
				.orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));
		
		if(!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
		}
		
		comment.setName(commentRequest.getName());
		comment.setEmail(commentRequest.getEmail());
		comment.setBody(commentRequest.getBody());
		
		Comment updatedComment = commentRepository.save(comment);
		return mapToDto(updatedComment);
	}
	
	
	@Override
	public void deleteComment(long postId, long commentId) {
		//retrieve post entity by id
		Post post = postRepository.findById(postId)
								.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
				
		//retrieve comment entity by id
		Comment comment = commentRepository.findById(commentId)
						.orElseThrow(()-> new ResourceNotFoundException("Comment", "id", commentId));
		
		//checking whether the comment exists for the post
		if(!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
		}
		
		commentRepository.delete(comment);
	}
	
	private CommentDto mapToDto(Comment comment) {
		
		CommentDto commentDto = mapper.map(comment, CommentDto.class);
		
		/*
		 * CommentDto commentDto = new CommentDto(); commentDto.setId(comment.getId());
		 * commentDto.setName(comment.getName());
		 * commentDto.setEmail(comment.getEmail());
		 * commentDto.setBody(comment.getBody());
		 */
		
		return commentDto;
	}
	
	private Comment mapToEntity(CommentDto commentDto) {
		
		Comment comment = mapper.map(commentDto, Comment.class);
		
		/*
		 * Comment comment = new Comment(); comment.setId(commentDto.getId());
		 * comment.setName(commentDto.getName());
		 * comment.setEmail(commentDto.getEmail());
		 * comment.setBody(commentDto.getBody());
		 */
		
		return comment;
	}

}

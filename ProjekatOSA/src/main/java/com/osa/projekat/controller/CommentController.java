package com.osa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osa.projekat.dto.CommentDTO;
import com.osa.projekat.dto.PostDTO;
import com.osa.projekat.model.Comment;
import com.osa.projekat.model.Post;
import com.osa.projekat.service.CommentServiceInterface;
import com.osa.projekat.service.PostServiceInterface;
import com.osa.projekat.service.UserServiceInterface;

@RestController(value = "news-api/comments")
public class CommentController {
	
	@Autowired
	CommentServiceInterface commentService;
	
	@Autowired
	PostServiceInterface postService;
	
	@Autowired
	UserServiceInterface userService;
	
	@GetMapping
	public ResponseEntity<List<CommentDTO>> getComments() {
		List<Comment> comments = commentService.findAll();
		//convert categories to DTOs
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for (Comment c : comments) {
			commentsDTO.add(new CommentDTO(c));
		}
		//vraca listu dto gotovih objekata spremnih za front
		return new ResponseEntity<List<CommentDTO>>(commentsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CommentDTO> getComment(@PathVariable("id") Integer id){
		Comment comment = commentService.findOne(id);
		if(comment == null) {
			return new ResponseEntity<CommentDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.OK);
		
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<CommentDTO> savePost(@RequestBody CommentDTO commentDTO){
		Comment comment = new Comment();
		comment.setTitle(commentDTO.getTitle());
		comment.setDescription(commentDTO.getDescription());
		comment.setDate(commentDTO.getDate());
		comment.setLikes(commentDTO.getLikes());
		comment.setDislikes(commentDTO.getDislikes());
		comment.setUser(userService.findOne(commentDTO.getUser().getId()));
		comment.setPost(postService.findOne(commentDTO.getPost().getId()));
		
		
		comment = commentService.save(comment);
		return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "/{id}", consumes = "application/json")
	public ResponseEntity<CommentDTO> updatePost(@RequestBody CommentDTO commentDTO, @PathVariable("id") Integer id){
		Comment comment = commentService.findOne(id);
		if (comment == null) {
			return new ResponseEntity<CommentDTO>(HttpStatus.BAD_REQUEST);
		}else {
			comment.setTitle(commentDTO.getTitle());
			comment.setDescription(commentDTO.getDescription());
			comment.setDate(commentDTO.getDate());
			comment.setLikes(commentDTO.getLikes());
			comment.setDislikes(commentDTO.getDislikes());
			comment.setUser(userService.findOne(commentDTO.getUser().getId()));
			comment.setPost(postService.findOne(commentDTO.getPost().getId()));
			
			comment = commentService.save(comment);
			return new ResponseEntity<CommentDTO>(new CommentDTO(comment), HttpStatus.CREATED);
		}
		
		
	}
	
	
	@PutMapping(value = "{id}/like")
	public ResponseEntity<Void> like(@PathVariable("id") Integer id){
		Comment comment = commentService.findOne(id);
		if(comment != null) {
			comment.setLikes(comment.getLikes() + 1);
			comment = commentService.save(comment);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "{id}/dislike")
	public ResponseEntity<Void> dislike(@PathVariable("id") Integer id){
		Comment comment = commentService.findOne(id);
		if(comment != null) {
			comment.setDislikes(comment.getDislikes() + 1);
			comment = commentService.save(comment);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id){
		Comment comment = commentService.findOne(id);
		if(comment != null) {
			commentService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	

}

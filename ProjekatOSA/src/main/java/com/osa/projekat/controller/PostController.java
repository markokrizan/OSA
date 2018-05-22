package com.osa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import com.osa.projekat.dto.CommentDTO;
import com.osa.projekat.dto.PostDTO;
import com.osa.projekat.dto.TagDTO;
import com.osa.projekat.model.Comment;
import com.osa.projekat.model.Post;
import com.osa.projekat.model.Tag;
import com.osa.projekat.service.CommentServiceInterface;
import com.osa.projekat.service.PostServiceInterface;
import com.osa.projekat.service.TagServiceInterface;
import com.osa.projekat.service.UserServiceInterface;

@RestController
@RequestMapping(value="news-api/posts/")
public class PostController {
	
	//polje servisnog interfejsa
	@Autowired
	private PostServiceInterface postService;
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private CommentServiceInterface commentService;
	
	@Autowired
	private TagServiceInterface tagService;
	
	//vrati sve postove
	//samo zadata rola moze da udje
	
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getPosts() {
		List<Post> posts = postService.findAll();
		System.out.println("posts " + posts);
		//convert categories to DTOs
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for (Post p : posts) {
			postsDTO.add(new PostDTO(p));
		}
		//vraca listu dto gotovih objekata spremnih za front
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMINISTRATOR')")
	@GetMapping("/test")
	public String testAutorizacije() {
		return "Uspelo!";
	}
	
	
	
	@GetMapping(value = "{id}")
	public ResponseEntity<PostDTO> getPost(@PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.OK);
		
	}
	
	//Komentari posta:
	@GetMapping(value = "{id}/comments")
	public ResponseEntity<List<CommentDTO>> getPostComments(@PathVariable("id") Integer id){
		List<Comment> comments = commentService.findByPostId(id);
		//convert categories to DTOs
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for (Comment c : comments) {
			commentsDTO.add(new CommentDTO(c));
		}
		//vraca listu dto gotovih objekata spremnih za front
		return new ResponseEntity<List<CommentDTO>>(commentsDTO, HttpStatus.OK);
		
		
	}
	
	//Tagovi posta:
	@GetMapping(value = "{id}/tags")
	public ResponseEntity<List<TagDTO>> getPostTags(@PathVariable("id") Integer id){
		List<Tag> tags = tagService.findByPostId(id);
		List<TagDTO> tagsDTO = new ArrayList<TagDTO>();
		for (Tag t : tags) {
			tagsDTO.add(new TagDTO(t));
		}
		return new ResponseEntity<List<TagDTO>>(tagsDTO, HttpStatus.OK);
		
	}
	
	//CREATE
	@PostMapping(consumes = "application/json")
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO){
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setPhoto(postDTO.getPhoto());
		post.setDate(postDTO.getDate());
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setUser(userService.findOne(postDTO.getUser().getId()));
		
		post = postService.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.CREATED);
		
	}
	
	//UPDATE
	@PutMapping(value = "{id}", consumes = "application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if (post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}else {
			post.setTitle(postDTO.getTitle());
			post.setDescription(postDTO.getDescription());
			post.setPhoto(postDTO.getPhoto());
			post.setDate(postDTO.getDate());
			post.setLikes(postDTO.getLikes());
			post.setDislikes(postDTO.getDislikes());
			post.setLongitude(postDTO.getLongitude());
			post.setLatitude(postDTO.getLatitude());
			post.setUser(userService.findOne(postDTO.getUser().getId()));
			
			post = postService.save(post);
			return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.CREATED);
		}
		
		
	}
	
	
	
	@PutMapping(value = "{id}/like")
	public ResponseEntity<Void> like(@PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if(post != null) {
			post.setLikes(post.getLikes() + 1);
			post = postService.save(post);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "{id}/dislike")
	public ResponseEntity<Void> dislike(@PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if(post != null) {
			post.setDislikes(post.getDislikes() + 1);
			post = postService.save(post);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//DELETE
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if(post != null) {
			postService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
}

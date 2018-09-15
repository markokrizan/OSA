package com.osa.projekat.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.osa.projekat.dto.RoleDTO;
import com.osa.projekat.dto.UserDTO;
import com.osa.projekat.model.Comment;
import com.osa.projekat.model.Post;
import com.osa.projekat.model.Role;
import com.osa.projekat.model.User;
import com.osa.projekat.service.CommentServiceInterface;
import com.osa.projekat.service.PostServiceInterface;
import com.osa.projekat.service.RoleServiceInterface;
import com.osa.projekat.service.UserServiceInterface;

@RestController
@RequestMapping(value="news-api/users/")
public class UserController {

	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private PostServiceInterface postService;
	
	@Autowired
	private CommentServiceInterface commentService;
	
	@Autowired
	private RoleServiceInterface roleService;
	
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<User> users = userService.findAll();
		//convert categories to DTOs
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for (User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		//vraca listu dto gotovih objekata spremnih za front
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") Integer id){
		User user = userService.findOne(id);
		if(user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "username/{username}")
	public ResponseEntity<UserDTO> getByUserName(@PathVariable("id") String username){
		User user = userService.findByUsername(username);
		if(user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "{id}/posts")
	public ResponseEntity<List<PostDTO>> getUsersPosts(@PathVariable("id") Integer id ){
		List<Post> posts = postService.findByUserId(id);
		List<PostDTO> postsDTO = new ArrayList<>();
		for (Post p : posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}/comments")
	public ResponseEntity<List<CommentDTO>> getUsersComments(@PathVariable("id") Integer id){
		List<Comment> comments = commentService.findByUserId(id);
		List<CommentDTO> commentsDTO = new ArrayList<>();
		for (Comment c : comments) {
			commentsDTO.add(new CommentDTO(c));
		}
		return new ResponseEntity<List<CommentDTO>>(commentsDTO, HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
			
		User user = new User();
		user.setName(userDTO.getName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setPhoto(userDTO.getPhoto());
		
		Set<Role> rolesToAdd = new HashSet<>();
		for (RoleDTO roleDTO : userDTO.getRoles()) {
			Role role = roleService.findOne(roleDTO.getRoleName());
			rolesToAdd.add(role);
		}
		user.setRoles(rolesToAdd);
		
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.CREATED);
	}
	

	@PutMapping(consumes = "application/json")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
		
		
		
		//User user = userService.findByUsername(userDTO.getUsername());
		User user = userService.findOne(userDTO.getId());
		if (user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}
		
		
		user.setName(userDTO.getName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setPhoto(userDTO.getPhoto());

		

		
		Set<Role> rolesToAdd = new HashSet<>();
		for (RoleDTO roleDTO : userDTO.getRoles()) {
			Role role = roleService.findOne(roleDTO.getId());
			rolesToAdd.add(role);
		}
		user.setRoles(rolesToAdd);
		

		
		
	
		
		
		userService.save(user);
	
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.CREATED);
		
		
		
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id){
		User user = userService.findOne(id);
		if(user != null) {
			userService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
	
}

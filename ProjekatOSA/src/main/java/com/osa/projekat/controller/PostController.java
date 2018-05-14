package com.osa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.projekat.dto.PostDTO;
import com.osa.projekat.model.Post;
import com.osa.projekat.service.PostServiceInterface;

@RestController
@RequestMapping(value="news-api/posts")
public class PostController {
	
	//polje servisnog interfejsa
	@Autowired
	private PostServiceInterface postService;
	
	//vrati sve postove
	//samo zadata rola moze da udje
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> getPosts() {
		List<Post> posts = postService.findAll();
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
	
	
	
	
	
	

}

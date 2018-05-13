package com.osa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.projekat.model.Post;
import com.osa.projekat.repository.PostRepository;

@Service
public class PostService implements PostServiceInterface {
	
	//Implementiras interfejs (sve njegove metode) i autowire-ujes repository u koji ce se servis spustati
	
	@Autowired
	PostRepository postRepository;
	

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findOne(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post save(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

}

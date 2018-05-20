package com.osa.projekat.service;

import java.util.List;
import java.util.Optional;

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
		return postRepository.getOne(postId);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void remove(Integer id) {
		postRepository.deleteById(id);
		
	}

}

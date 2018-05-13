package com.osa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.projekat.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	//Samo prosiranja?
	//List<Post> findAll();
	

}

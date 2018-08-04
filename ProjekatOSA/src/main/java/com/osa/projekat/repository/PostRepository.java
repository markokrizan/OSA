package com.osa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osa.projekat.model.Comment;
import com.osa.projekat.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	@Query(value = "SELECT * FROM posts WHERE user_id = ?1", nativeQuery = true)
	List<Post> findByUserId(Integer userId);
	

}

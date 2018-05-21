package com.osa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osa.projekat.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	
	@Query(value = "SELECT * FROM comments WHERE post_id = ?1", nativeQuery = true)
	List<Comment> findByPostId(Integer postId);

}

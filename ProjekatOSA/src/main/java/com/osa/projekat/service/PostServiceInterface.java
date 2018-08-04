package com.osa.projekat.service;

import java.util.List;

import com.osa.projekat.model.Comment;
import com.osa.projekat.model.Post;

public interface PostServiceInterface {
	
	
	List<Post> findAll();
	
	
	Post findOne(Integer postId);
	
	
	List<Post> findByUserId(Integer userId);
	

	Post save(Post post);
	
	
	void remove(Integer id);
	
	
	
	

}

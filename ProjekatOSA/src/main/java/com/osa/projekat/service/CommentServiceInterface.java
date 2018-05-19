package com.osa.projekat.service;

import java.util.List;

import com.osa.projekat.model.Comment;

public interface CommentServiceInterface {
	
	List<Comment> findAll();
	
	
	Comment findOne(Integer commentId);
	

	Comment save(Comment comment);
	
	
	void remove(Integer id);

}

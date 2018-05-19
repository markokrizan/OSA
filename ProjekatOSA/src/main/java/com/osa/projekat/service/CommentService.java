package com.osa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.projekat.model.Comment;
import com.osa.projekat.repository.CommentRepository;

@Service
public class CommentService implements CommentServiceInterface {

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

	@Override
	public Comment findOne(Integer commentId) {
		return commentRepository.getOne(commentId);
	}

	@Override
	public Comment save(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}

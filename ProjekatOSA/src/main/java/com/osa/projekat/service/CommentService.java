package com.osa.projekat.service;

import java.util.ArrayList;
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
	public List<Comment> findByPostId(Integer postId){
		return new ArrayList<>(commentRepository.findByPostId(postId));
	}
	
	@Override
	public List<Comment> findByUserId(Integer userId){
		return new ArrayList<>(commentRepository.findByUserId(userId));
	}

	@Override
	public Comment findOne(Integer commentId) {
		return commentRepository.getOne(commentId);
	}

	@Override
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	@Override
	public void remove(Integer id) {
		commentRepository.deleteById(id);
		
	}
	
	

}

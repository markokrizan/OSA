package com.osa.projekat.service;

import java.util.List;

import com.osa.projekat.model.Tag;

public interface TagServiceInterface {
	
	List<Tag> findAll();
	
	
	List<Tag> findByPostId(Integer postId);
	
	
	Tag findOne(Integer tagId);
	

	Tag save(Tag tag);
	
	
	void remove(Integer id);

}

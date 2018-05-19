package com.osa.projekat.service;

import java.util.List;

import com.osa.projekat.model.User;

public interface UserServiceInterface {
	
	List<User> findAll();
	
	
	User findOne(Integer userId);
	

	User save(User user);
	
	
	void remove(Integer id);

}

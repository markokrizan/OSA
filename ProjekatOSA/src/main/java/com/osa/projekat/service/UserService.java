package com.osa.projekat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.projekat.model.User;
import com.osa.projekat.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(Integer userId) {
		return userRepository.getOne(userId);
	}
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	
	}

	@Override
	public void remove(Integer id) {
		userRepository.deleteById(id);
		
	}

	
	
	

}

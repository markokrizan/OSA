package com.osa.projekat.service;

import java.util.List;

import com.osa.projekat.model.Comment;
import com.osa.projekat.model.Role;

public interface RoleServiceInterface {

	
	List<Role> findAll();
	
	
	Role findOne(Integer roleId);
	
	
	Role findOne(String roleName);
	
	//po specifikaciji nema ovih operacija
	
	/*
	Comment save(Role role);
	
	
	void remove(Integer id);
	*/
	
}

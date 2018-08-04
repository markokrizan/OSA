package com.osa.projekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osa.projekat.model.Role;
import com.osa.projekat.repository.RoleRepository;

@Service
public class RoleService implements RoleServiceInterface{
	
	@Autowired
	RoleRepository roleRepository;

	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findOne(Integer roleId) {
		return roleRepository.getOne(roleId);
	}

	@Override
	public Role findOne(String roleName) {
		return roleRepository.findByRole(roleName);
	}

}

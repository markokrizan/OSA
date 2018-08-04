package com.osa.projekat.repository;

import com.osa.projekat.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	//Role findOne(String roleName);
	
	Role findByRole(String roleName);
}

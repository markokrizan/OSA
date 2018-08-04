package com.osa.projekat.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.osa.projekat.model.Role;
import com.osa.projekat.model.Tag;

public class RoleDTO implements Serializable{

	private Integer id;
	private String roleName;
	
	
	
	public RoleDTO() {
		super();
	}
	
	
	public RoleDTO(Integer id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	
	
	public RoleDTO(Role role) {
		this(role.getId(), role.getRole());
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	public static Set<RoleDTO> entityToDto(Set<Role> entitySet){
		Set<RoleDTO> dtoSet = new HashSet<>();
		for (Role role : entitySet) {
			RoleDTO roleDTO = new RoleDTO(role);
			dtoSet.add(roleDTO);
		}
		return dtoSet;
	}
	
	
}

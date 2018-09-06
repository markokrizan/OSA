package com.osa.projekat.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.osa.projekat.model.User;



public class UserDTO implements Serializable{
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private String photo;
	private Set<RoleDTO> roles;
	
	/*
	private ArrayList<PostDTO> posts;
	private List<CommentDTO> comments;
	*/
	
	
	
	public UserDTO() {
		super();
	}
	
	/*
	
	public UserDTO(Integer id, String name, String username, String password, String photo, Set<RoleDTO> roles,
			ArrayList<PostDTO> posts, List<CommentDTO> comments) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.roles = roles;
		this.posts = posts;
		this.comments = comments;
	}
	
	public UserDTO(User user) {
	this(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getPhoto(),
			RoleDTO.entityToDto(user.getRoles()), PostDTO.entityToDto(user.getPosts()), CommentDTO.entityToDto(user.getComments()));
	}
	*/
	
	
	public UserDTO(Integer id, String name, String username, String password, String photo, Set<RoleDTO> roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.photo = photo;
		this.roles = roles;
		
	}
	
	
	public UserDTO(User user) {
		this(user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getPhoto(),
				RoleDTO.entityToDto(user.getRoles()));
	}



	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Set<RoleDTO> getRoles() {
		return roles;
	}



	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", photo="
				+ photo + ", roles=" + roles + "]";
	}


	/*
	public ArrayList<PostDTO> getPosts() {
		return posts;
	}



	public void setPosts(ArrayList<PostDTO> posts) {
		this.posts = posts;
	}



	public List<CommentDTO> getComments() {
		return comments;
	}



	public void setComments(ArrayList<CommentDTO> comments) {
		this.comments = comments;
	}
	*/
	
	
	
	
	
	

}

package com.osa.projekat.dto;

import com.osa.projekat.model.User;



public class UserDTO {
	
	Integer id;
	String username;
	String photo;
	
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(Integer id, String username, String photo) {
		super();
		this.id = id;
		this.username = username;
		this.photo = photo;
	}
	
	//ovim konstruktorom pravis od DAO DTO
	public UserDTO(User user) {
		//pozovi drugi konstruktor u istoj klasi sa ovim setom parametara, zato ti i treba onaj
		this(user.getId(), user.getUsername(), user.getPhoto());
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
	
	
	
	

}

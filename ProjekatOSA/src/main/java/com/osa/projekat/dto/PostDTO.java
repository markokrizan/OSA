package com.osa.projekat.dto;

import java.io.Serializable;
import java.util.Date;

import com.osa.projekat.model.Post;

public class PostDTO implements Serializable{
	
	//Data Transfer Object - sluzi da se od DAO objekta snime samo ona obelezja koja treba serijalizovati preko mreze
	//Obicno sa specijalizovanim podacima za GUI, mozes ih napraviti vise od jednog DAO objekta
	
	private Integer id;
	private String title;
	private String description;
	private String photo;
	private Date date;
	private Integer likes;
	private Integer dislikes;
	private Double longitude;
	private Double latitude;
	private UserDTO user;
	
	public PostDTO() {
		super();
	}

	public PostDTO(Integer id, String title, String description, String photo, Date date, Integer likes,
			Integer dislikes, Double longitude, Double latitude, UserDTO user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.photo = photo;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		this.longitude = longitude;
		this.latitude = latitude;
		this.user = user;
	}
	
	public PostDTO(Post post) {
		this(post.getId(), post.getTitle(), post.getDescription(), post.getPhoto(),
				post.getDate(), post.getLikes(), post.getDislikes(), post.getLongitude(), post.getLatitude(),
				new UserDTO(post.getUser()));
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getDislikes() {
		return dislikes;
	}

	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	

}

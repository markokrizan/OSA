package com.osa.projekat.dto;

import java.util.Date;

import com.osa.projekat.model.Comment;

public class CommentDTO {
	
	Integer id;
	String title;
	String description;
	Date date;
	Integer likes;
	Integer dislikes;
	PostDTO post;
	UserDTO user;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(Integer id, String title, String description, Date date, Integer likes, Integer dislikes, PostDTO post,
			UserDTO user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		this.post = post;
		this.user = user;
	}
	
	public CommentDTO(Comment comment) {
		this(comment.getId(), comment.getTitle(), comment.getDescription(), comment.getDate(), comment.getLikes(), comment.getDislikes(),
				new PostDTO(comment.getPost(), comment.getPost().getComments().size()), new UserDTO(comment.getUser()));
		
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

	public PostDTO getPost() {
		return post;
	}

	public void setPost(PostDTO post) {
		this.post = post;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	
	
	
	
	
	

}

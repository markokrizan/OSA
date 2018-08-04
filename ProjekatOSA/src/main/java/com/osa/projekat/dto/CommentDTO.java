package com.osa.projekat.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.osa.projekat.model.Comment;

public class CommentDTO {
	
	Integer id;
	String title;
	String description;
	Date date;
	Integer likes;
	Integer dislikes;
	
	Integer postId;
	UserDTO user;
	
	public CommentDTO() {
		super();
	}

	public CommentDTO(Integer id, String title, String description, Date date, Integer likes, Integer dislikes, Integer postId,
			UserDTO user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		this.postId = postId;
		this.user = user;
	}
	
	public CommentDTO(Comment comment) {
		this(comment.getId(), comment.getTitle(), comment.getDescription(), comment.getDate(), comment.getLikes(), comment.getDislikes(),
				comment.getPost().getId(), new UserDTO(comment.getUser()));
		
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

	
	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
	public static List<CommentDTO> entityToDto(List<Comment> entityList){
		List<CommentDTO> dtoList = new ArrayList<>();
		for (Comment comment : entityList) {
			CommentDTO commentDTO = new CommentDTO(comment);
			dtoList.add(commentDTO);
		}
		return dtoList;
	}
	
	
	
	
	

}

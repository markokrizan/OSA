package com.osa.projekat.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	//length + string tip = varchar(length)
	@Column(name="name", unique=false, nullable=false, length = 30)
	private String name;
	
	@Column(name="username", unique=false, nullable=false, length = 30)
	private String username;
	
	@Column(name="password", unique=false, nullable=false, length = 10)
	private String password;
	
	//samo string putanja za sada
	@Column(name="photo", unique=false, nullable=false)
	private String photo;
	
	
	
	
	//VEZE
	//1. USER ONE -------------- MANY POSTS
	private ArrayList<Post> posts = new ArrayList<>();
	
	//add i remove
	//da se apdejtuje veza sa druge strane
	public void addPost(Post post) {
		posts.add(post);
		//apdejtuj vezu sa druge strane
		post.setUser(this);
	}
	 
	public void removePost(Post post) {
	    posts.remove(post);
	    post.setUser(null);
	}
	
	
	//2. USER ONE -------------- MANY COMMENTS
	private ArrayList<Comment> comments = new ArrayList<>();
		
		//add i remove
		//da se apdejtuje veza sa druge strane
	public void addComment(Comment comment) {
		comments.add(comment);
			//apdejtuj vezu sa druge strane
		comment.setUser(this);
	}
		 
	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setUser(null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public ArrayList<Post> getPosts() {
		return posts;
	}

	public void setPosts(ArrayList<Post> posts) {
		this.posts = posts;
	}

	public ArrayList<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	

}

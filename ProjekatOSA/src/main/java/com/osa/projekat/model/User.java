package com.osa.projekat.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User {
	

	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	//promenio zbog indijskog djubreta sa id na user_id
	@Column(name="user_id", unique=true, nullable=false)
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
	//Indijksa veza:
	//1. USER ONE ------------- MANY ROLES
	//Users, roles, user_roles su tabele
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // OVO BILO ORIGINALNO
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	//1. USER ONE -------------- MANY POSTS
	private ArrayList<Post> posts = new ArrayList<>();
	
	
	public User() {
		
	}
	
	//konstruktor kopije za CustomUserDetails:
	public User(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.photo = user.getPhoto();
		//bez veza
	}
	
	
	
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
	
	
	//Role:
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		roles.add(role);
		//apdejtuj vezu sa druge strane ako treba!
		
	}
	 
	public void removeRole(Role role) {
	    roles.remove(role);
	    //apdejtuj vezu sa druge strane ako treba!
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", photo="
				+ photo + ", roles=" + roles + ", posts=" + posts + ", comments=" + comments + "]";
	}
	
	
	
	
	
	
	
	
	
	

}

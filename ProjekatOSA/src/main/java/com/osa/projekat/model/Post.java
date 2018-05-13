package com.osa.projekat.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="posts")
public class Post implements Serializable{
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="title", unique=false, nullable=false, length = 100)
	private String title;
	
	//mapiranje za Text tip u bp
	@Lob
	@Column(name="description", unique=false, nullable=false)
	private String description;
	
	//za sada neka bude putanja u stringu
	@Column(name="photo", unique=false, nullable=false)
	private String photo;
	
	//java.util.date! vidi da li ce bolje biti sa sql.date
	@Column(name="post_date", unique=false, nullable=false)
	private Date date;
	
	//default-na vrednost 0 i za lajk i dislajk
	@Column(name="likes", unique=false, nullable=false, columnDefinition = "int default 0")
	private Integer likes;
	
	@Column(name="dislikes", unique=false, nullable=false, columnDefinition = "int default 0")
	private Integer dislikes;
	
	@Column(name="longitude", unique=false, nullable=false)
	private Float longitude;
	
	@Column(name="latitude", unique=false, nullable=false)
	private Float latitude;
	
	//VEZE
	
	//1. POST ONE --------- MANY COMMENT
	//bidirekcionalna veza, sa obe strane - ovde kolekcija, tamo samo referenca na post
	//You are not allowed to use a concrete implementation on the entities field declaration. You are allowed to use one of the following:
	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();
	
	//add i remove
	//da se apdejtuje veza sa druge strane
	public void addComment(Comment comment) {
		comments.add(comment);
		//apdejtuj vezu sa druge strane
		comment.setPost(this);
	}
	 
	public void removeComment(Comment comment) {
	    comments.remove(comment);
	    comment.setPost(null);
	}
	
	/* 
	 primer perzistiranja:
	 
	    Post post = new Post("First post");
 
		post.addComment(
		    new PostComment("My first review")
		);
		post.addComment(
		    new PostComment("My second review")
		);
		post.addComment(
		    new PostComment("My third review")
		);
		 
		entityManager.persist(post);
	 
	 */
	
	
	//2. MANY POSTS --------------------- ONE USER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
		
	//3. MANY POSTS ---------------------- MANY TAGS
	//bridge tabela
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "posts_tags",joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();
		
	public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPosts().add(this);
    }
 
    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }
	
	
	

	
	@Override
	public boolean equals(Object o) {
	     if (this == o) return true;
	     if (!(o instanceof Post )) return false;
	     return id != null && id.equals(((Post) o).id);
	}
		
		
	@Override
		public int hashCode() {
		return 31;
	}
	
	
	//-----------------------------------------------------
	    
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

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	

}

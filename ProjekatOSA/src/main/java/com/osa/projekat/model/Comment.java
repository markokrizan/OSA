package com.osa.projekat.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	private Integer id;
	
	@Column(name="title", unique=false, nullable=false, length = 100)
	private String title;
	
	@Lob
	@Column(name="description", unique=false, nullable=false)
	private String description;
	
	@Column(name="comment_date", unique=false, nullable=false)
	private Date date;
	
	@Column(name="likes", unique=false, nullable=false)
	private Integer likes;
	
	@Column(name="dislikes", unique=false, nullable=false)
	private Integer dislikes;
	
	//veze
	
	//1. MANY COMMENTS --------------------- ONE POST
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
	
	
	//1. MANY COMMENTS --------------------- ONE USER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	
	
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment )) return false;
        return id != null && id.equals(((Comment) o).id);
    }
	
	
    @Override
    public int hashCode() {
        return 31;
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
    
	

    
    
    
    
	
	

}

package com.osa.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.projekat.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

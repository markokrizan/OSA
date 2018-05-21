package com.osa.projekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.osa.projekat.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
	
	@Query(value = "SELECT * FROM tags WHERE id IN (SELECT tag_id FROM posts_tags WHERE post_id = ?1)", nativeQuery = true)
	List<Tag> findByPostId(Integer postId);

}

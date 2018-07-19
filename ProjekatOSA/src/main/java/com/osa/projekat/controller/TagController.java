package com.osa.projekat.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.projekat.dto.TagDTO;
import com.osa.projekat.model.Post;
import com.osa.projekat.model.Tag;
import com.osa.projekat.service.TagServiceInterface;

@RestController
@RequestMapping(value = "news-api/tags/")
public class TagController {

	@Autowired
	private TagServiceInterface tagService;
	
	@GetMapping
	public ResponseEntity<List<TagDTO>> getTags(){
		List<Tag> tags = tagService.findAll();
		
		List<TagDTO> tagsDTO = new ArrayList<>();
		for (Tag t : tags) {
			tagsDTO.add(new TagDTO(t));
		}
		
		return new ResponseEntity<List<TagDTO>>(tagsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<TagDTO> getPost(@PathVariable("id") Integer id){
		Tag tag = tagService.findOne(id);
		if(tag == null) {
			return new ResponseEntity<TagDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.OK);
		
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<TagDTO> saveTag(@RequestBody TagDTO tagDTO){
		Tag tag = new Tag();
		tag.setName(tagDTO.getName());
		
		
		tag = tagService.save(tag);
		return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.CREATED);
		
	}
	
	@PutMapping(value = "{id}", consumes = "application/json")
	public ResponseEntity<TagDTO> updateTag(@RequestBody TagDTO tagDTO, @PathVariable("id") Integer id){
		Tag tag = tagService.findOne(id);
		if (tag == null) {
			return new ResponseEntity<TagDTO>(HttpStatus.BAD_REQUEST);
		}else {
			tag.setName(tagDTO.getName());
			tag = tagService.save(tag);
			return new ResponseEntity<TagDTO>(new TagDTO(tag), HttpStatus.CREATED);
		}
		
		
		
	}
	
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Void> deleteTag(@PathVariable("id") Integer id){
		Tag tag = tagService.findOne(id);
		if(tag != null) {
			tagService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	
	
	
	
	
}

package com.osa.projekat.dto;

import java.util.HashSet;
import java.util.Set;

import com.osa.projekat.model.Tag;

public class TagDTO {
	Integer id;
	String name;
	
	public TagDTO() {
		super();
	}

	public TagDTO(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public TagDTO(Tag tag) {
		this(tag.getId(), tag.getName());
		
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
	
	
	//converter from collection of tags to collection of tagDTOs
	
	public static Set<TagDTO> entityToDto(Set<Tag> entitySet){
		Set<TagDTO> dtoSet = new HashSet<>();
		for (Tag tag : entitySet) {
			TagDTO tagDTO = new TagDTO(tag);
			dtoSet.add(tagDTO);
		}
		return dtoSet;
	}
	
	
	
	

}

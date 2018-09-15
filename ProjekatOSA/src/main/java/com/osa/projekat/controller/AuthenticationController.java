package com.osa.projekat.controller;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.osa.projekat.dto.RoleDTO;
import com.osa.projekat.dto.UserDTO;
import com.osa.projekat.model.Role;
import com.osa.projekat.model.User;
import com.osa.projekat.service.RoleServiceInterface;
import com.osa.projekat.service.UserServiceInterface;

//Najgora abominacija od koda ikada napisana - duboka sramota treba da usledi nakon svake napisane linije

@RestController
public class AuthenticationController {
	
	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private RoleServiceInterface roleService;
	
	//uzmi neki skrbavi json u kojem je username i password i onda vrati ako nadjes celog korisnika pa ga jebi tamo 
	@PostMapping(value = "/login", headers = {"content-type=application/x-www-form-urlencoded"})
	public ResponseEntity<UserDTO>  login(WebRequest request){
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userService.findByUsername(username);
		if(user == null) {
			//ovo glumi token i ide u session local storage
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}else if(user.getPassword().equals(password)) {
			return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
		}else {
			return new ResponseEntity<UserDTO>(HttpStatus.UNAUTHORIZED);
		}
		
		
	}
	
	//obicna ona metoda iz user-a, mozda i ne tu
	@PostMapping(value = "/register", consumes = "application/json")
	public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
		User user = new User();
		if(userService.findByUsername(userDTO.getUsername()) != null) {
			return new ResponseEntity<UserDTO>(HttpStatus.CONFLICT);
		}
		user.setName(userDTO.getName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setPhoto(userDTO.getPhoto());
		
		Set<Role> rolesToAdd = new HashSet<>();
		for (RoleDTO roleDTO : userDTO.getRoles()) {
			Role role = roleService.findOne(roleDTO.getRoleName());
			rolesToAdd.add(role);
		}
		user.setRoles(rolesToAdd);
		
		user = userService.save(user);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.CREATED);
		
	}

}

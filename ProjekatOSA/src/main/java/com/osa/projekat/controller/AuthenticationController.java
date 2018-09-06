package com.osa.projekat.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osa.projekat.dto.RoleDTO;
import com.osa.projekat.dto.UserDTO;
import com.osa.projekat.model.Role;
import com.osa.projekat.model.User;
import com.osa.projekat.service.RoleServiceInterface;
import com.osa.projekat.service.UserServiceInterface;

@RestController
@RequestMapping("/news-api/")
public class AuthenticationController {

	@Autowired
	private UserServiceInterface userService;
	
	@Autowired
	private RoleServiceInterface roleService;
	
	
	
	//dodat kao Bean u main-u, ne znam da li bi radio drugacije ili da li moze da se autowire-uje
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthenticationController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
           
        User user = new User();
		user.setName(userDTO.getName());
		user.setUsername(userDTO.getUsername());
		
		//enkoduj password i takvog ga cuvaj u bazi
		user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
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

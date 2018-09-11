package com.osa.projekat.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//Najgora abominacija od koda ikada napisana - duboka sramota treba da usledi nakon svake napisane linije

@RestController
public class AuthenticationController {
	
	
	//uzmi neki skrbavi json u kojem je username i password i onda vrati ako nadjes celog korisnika pa ga jebi tamo 
	@GetMapping(value = "/login")
	public String login(){
		return "Login";
		
	}
	
	@GetMapping(value = "/register")
	public String register(){
		return "Register";
		
	}

}

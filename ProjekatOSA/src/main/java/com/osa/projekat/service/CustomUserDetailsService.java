package com.osa.projekat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.osa.projekat.model.CustomUserDetails;
import com.osa.projekat.model.User;
import com.osa.projekat.repository.UserRepository;

//ovo je klasa koja ce da implementira iz ugradjenog UserDetailsService, ne znaci da ne ce biti jos servisa vezanih za korisnike
//ovo je za autentikaciju
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	//vraca objekat tipa UserDetails, to je ugradjeni interfejs koji mora poseban entitet da implementira
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//uzmi korisnika iz repositoryja za korisnike
		Optional<User> optionalUsers = userRepository.findByUsername(username);
		//bukvalno ovde je login logika:
		optionalUsers
				//ne postojeci username:
				.orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
		//postoji:
		return optionalUsers
				//t's syntactic sugar to have the compiler auto-generate interface implementations based on the function you provide
				.map(CustomUserDetails::new).get();
	}
	
	

}

package com.osa.projekat.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//poseban entitet koji je potreban za autentikaciju, ali takodje mora da nasledi i od same user klase jer su tamo i sve veze i ostala polja
public class CustomUserDetails extends User implements UserDetails {
	
	
	//u konstruktoru prosledis zapravog korisnika od kojeg radis ostalo
	public CustomUserDetails(final User user) {
		super(user);
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
			.stream()
			.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
			.collect(Collectors.toList());
		
	}

	@Override
	public String getPassword() {
		//sada uzmes od nadklase User sve podatke koji su ti ovde potrebni
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		//defaultno setovanje, moglo je biti polje u klasi i kolona u tabeli sa flegom....
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}

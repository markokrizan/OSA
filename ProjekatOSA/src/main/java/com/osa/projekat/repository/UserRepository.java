package com.osa.projekat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osa.projekat.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	//Optional je za slucaj da username ne postoji, vrepujes return type u optional - od jave 8
	Optional<User> findByUsername(String username);

}

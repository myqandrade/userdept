package com.projetoteste.userdept.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoteste.userdept.entities.User;
import com.projetoteste.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll(){
		List<User> users = userRepository.findAll();
		return users;
	}

	@GetMapping("/{id}")
	public Optional<User> findById(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
}

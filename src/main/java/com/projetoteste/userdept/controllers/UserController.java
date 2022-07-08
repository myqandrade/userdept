package com.projetoteste.userdept.controllers;

import java.util.List;
import java.util.Optional;

import com.projetoteste.userdept.entities.UserDTO;
import com.projetoteste.userdept.service.UserService;
import com.projetoteste.userdept.entities.User;
import com.projetoteste.userdept.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
	private final UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		return ResponseEntity.ok(userService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(userService.findById(id));
	}
}

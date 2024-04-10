package com.example.controller;

import com.example.dto.UserRequest;
import com.example.entity.User;
import com.example.exception.UserNotFoundException;
import com.example.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<>(service.saveUser(userRequest), HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(service.getALlUsers());
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(service.getUser(id));
	}
}

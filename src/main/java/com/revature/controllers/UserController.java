package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.daos.IUserDao;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
	
	@Autowired
	private IUserDao dao;
	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		dao.findById(1);
		return ResponseEntity.accepted().body("Welcome to Spring Boot!");
	}

}

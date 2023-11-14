package com.spring.e_commerce_back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.e_commerce_back.entities.AppUser;
import com.spring.e_commerce_back.services.AppUserService;

@RestController
@RequestMapping(path = "/api/user")
public class AppUserController {
	
	@Autowired
	private AppUserService appUserService;
	
	@PostMapping(path ="/auth/register")
	public ResponseEntity<?> register(@RequestBody AppUser user){
		return appUserService.register(user);
	}
	
	@PostMapping(path = "/auth/login")
	public ResponseEntity<?> login (@RequestBody AppUser user){
		return appUserService.login(user);
	}

}

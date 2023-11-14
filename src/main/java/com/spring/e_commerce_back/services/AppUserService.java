package com.spring.e_commerce_back.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.e_commerce_back.entities.AppUser;
import com.spring.e_commerce_back.payloads.responseEntityMessages.UserLoginMessage;
import com.spring.e_commerce_back.repositories.AppUserRepository;

@Service
public class AppUserService {

	@Autowired
	private AppUserRepository appUserRepository;

	public ResponseEntity<?> register(AppUser user) {

		Optional<AppUser> optionalUser = appUserRepository.findByUsername(user.getUsername());

		if (optionalUser.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
		}

		AppUser savedUser = appUserRepository.save(user);
		return ResponseEntity.status(HttpStatus.OK).body(savedUser);
	}

	public ResponseEntity<?> login(AppUser user) {
		Optional<AppUser> optionalUser = appUserRepository.findByUsername(user.getUsername());

		if (optionalUser.isPresent()) {
			//@formatter:off
			UserLoginMessage message = new UserLoginMessage.Builder()
					.atDate(new Date())
					.withUsername(user.getUsername())
					.isConnected(true)
					.build();
			//@formatter:on

			return ResponseEntity.status(HttpStatus.OK).body(message);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	}
	

}

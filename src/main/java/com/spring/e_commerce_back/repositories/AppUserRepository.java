package com.spring.e_commerce_back.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.e_commerce_back.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
	
	Optional<AppUser> findByUsername(String username);

}

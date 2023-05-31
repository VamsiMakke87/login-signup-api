package com.login.api.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.api.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}

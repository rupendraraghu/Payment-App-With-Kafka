package com.wellsfargo.microservice.app.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wellsfargo.microservice.app.domain.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	User findByUsername(String username);

	Optional<User> findByEmail(String email);

	Optional<User> findByPhoneNumber(String phoneNumber);

}

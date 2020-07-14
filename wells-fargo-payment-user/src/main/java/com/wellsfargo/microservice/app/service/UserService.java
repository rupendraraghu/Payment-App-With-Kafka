package com.wellsfargo.microservice.app.service;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.microservice.app.domain.User;

public interface UserService {

	List<User> getAllUsers();

	Optional<User> getUserByEmail(String email);

	Optional<User> getUserByPhoneNumber(String phoneNumber);
}

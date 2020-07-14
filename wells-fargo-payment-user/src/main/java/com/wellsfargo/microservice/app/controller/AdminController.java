package com.wellsfargo.microservice.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.microservice.app.domain.User;
import com.wellsfargo.microservice.app.exception.UserNotFoundException;
import com.wellsfargo.microservice.app.service.CustomUserDetailsService;
import com.wellsfargo.microservice.app.service.UserService;

@RestController
@RequestMapping("/secure/auth/admin-management")
public class AdminController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private UserService userService;

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user) {
		customUserDetailsService.saveUser(user);
		return "user added successfully...";
	}

	// @PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/all")
	public String securedHello() {
		return "Secured Hello";
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/customer/{email}")
	public User getCustomerByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User with email :" + email + " not found"));
	}

	@GetMapping("/customer/{phoneNumber}")
	public User getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
		return userService.getUserByPhoneNumber(phoneNumber)
				.orElseThrow(() -> new UserNotFoundException("User with Phone Number :" + phoneNumber + " not found"));
	}
}

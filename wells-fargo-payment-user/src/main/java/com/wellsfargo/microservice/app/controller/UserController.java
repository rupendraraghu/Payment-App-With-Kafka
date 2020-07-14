package com.wellsfargo.microservice.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class UserController {

	@GetMapping("/process")
	public String process() {
		return "processing..";
	}
}

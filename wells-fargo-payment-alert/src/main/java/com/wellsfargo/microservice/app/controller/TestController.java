package com.wellsfargo.microservice.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.microservice.app.service.SmsService;

@RestController
public class TestController {
	@Autowired
	private SmsService smsService;

	@GetMapping("/test")
	private String test() {
		smsService.sendSms("Hello");
		return "Hello";
	}

}

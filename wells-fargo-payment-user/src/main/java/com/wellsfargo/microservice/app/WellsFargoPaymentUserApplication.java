package com.wellsfargo.microservice.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wellsfargo.microservice.app.dao.RoleRepository;
import com.wellsfargo.microservice.app.domain.Role;

@SpringBootApplication
public class WellsFargoPaymentUserApplication implements CommandLineRunner {
	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(WellsFargoPaymentUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role adminRole = roleRepository.findByRole("ADMIN");
		if (adminRole == null) {
			Role newAdminRole = new Role();
			newAdminRole.setId(1);
			newAdminRole.setRole("ADMIN");
			roleRepository.save(newAdminRole);
		}

		Role userRole = roleRepository.findByRole("USER");
		if (userRole == null) {
			Role newUserRole = new Role();
			newUserRole.setId(2);
			newUserRole.setRole("USER");
			roleRepository.save(newUserRole);
		}

	}

}

package com.wellsfargo.microservice.app.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wellsfargo.microservice.app.domain.Role;

public interface RoleRepository extends MongoRepository<Role, Integer> {

	Role findByRole(String role);

}

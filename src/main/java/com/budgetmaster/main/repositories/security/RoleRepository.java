package com.budgetmaster.main.repositories.security;

import com.budgetmaster.main.models.security.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
}

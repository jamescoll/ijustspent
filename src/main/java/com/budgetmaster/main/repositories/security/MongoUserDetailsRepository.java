package com.budgetmaster.main.repositories.security;


import com.budgetmaster.main.models.security.MongoUserDetails;
import com.budgetmaster.main.models.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoUserDetailsRepository extends MongoRepository<MongoUserDetails, String> {

    MongoUserDetails findByUsername(String username);
}

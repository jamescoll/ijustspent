package com.budgetmaster.main.repositories.security;

import com.budgetmaster.main.models.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(final String userName);
}

package com.budgetmaster.main.services;

import com.budgetmaster.main.models.security.User;

import java.util.List;


public interface UserService {

    User create(User object);

    User find(String id);

    User findByUsername(String userName);

    List<User> findAll();

    User update(String id, User object);

    String delete(String id);
}

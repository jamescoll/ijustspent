package com.budgetmaster.main.services;

import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.repositories.security.UserRepository;
import com.budgetmaster.main.security.helpers.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BasicUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    public BasicUserService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(final User user) {
        User newUser = repository.findByUsername(user.getUsername());

        if(newUser == null) {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
            user.setPassword(PasswordHelper.hashPassword(user.getPassword()));
            return repository.save(user);
        }

        return newUser;

    }

    //todo this is the wrong way to do this and not functional - work out the functional way
    @Override
    public User find(final String id) {
        if (repository.findById(id).isPresent()){
            return repository.findById(id).get();
        }
        return null;
    }

    @Override
    public User findByUsername(final String userName) {
        return repository.findByUsername(userName);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User update(final String id, final User user) {

        //todo this is terrible - refactor this
        User saved = null;

        if (repository.findById(id).isPresent()){
            saved = repository.findById(id).get();
        }

        if (saved != null) {
            user.setCreatedAt(saved.getCreatedAt());
            user.setUpdatedAt(String.valueOf(LocalDateTime.now()));
        } else {
            user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        }
        repository.save(user);
        return user;
    }

    @Override
    public String delete(final String id) {
        repository.deleteById(id);
        return id;
    }
}

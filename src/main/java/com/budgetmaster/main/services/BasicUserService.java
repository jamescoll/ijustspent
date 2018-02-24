package com.budgetmaster.main.services;

import com.budgetmaster.main.exceptions.model.UserNotFoundException;
import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.repositories.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class BasicUserService implements UserService {

    private final UserRepository repository;

    @Autowired
    public BasicUserService(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(final User user) {
        user.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return repository.save(user);
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
        user.setId(id);

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

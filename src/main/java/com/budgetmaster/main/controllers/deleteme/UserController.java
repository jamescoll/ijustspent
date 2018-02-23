package com.budgetmaster.main.controllers.deleteme;

import com.budgetmaster.main.models.security.MongoUserDetails;
import com.budgetmaster.main.repositories.security.MongoUserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private MongoUserDetailsRepository mongoUserDetailsRepository;

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<MongoUserDetails> getUsers(){
        return mongoUserDetailsRepository.findAll();
    }
}
package com.budgetmaster.main.services;

import com.budgetmaster.main.models.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUserService {

    @Autowired
    UserService userService;

    {
        loggedInUser = new User();
    }

    private User loggedInUser;



    public void logOut(){
        loggedInUser = new User();
    }

    public void setLoggedInUser(String username){
        loggedInUser = userService.findByUsername(username);
    }

    public User getLoggedInUser(){
        return loggedInUser;
    }
}

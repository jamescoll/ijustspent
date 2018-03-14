package com.ijustspent.main.services;

import com.ijustspent.main.models.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggedInUserService {

    @Autowired
    UserService userService;

    //todo verify if this is necessary as it's here to avoid an NPE
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

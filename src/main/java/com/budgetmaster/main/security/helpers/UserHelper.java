package com.budgetmaster.main.security.helpers;

import com.budgetmaster.main.models.security.User;

public class UserHelper {

    private static User loggedInUser = new User();

    public static boolean isLoggedIn() {
        return !loggedInUser.getUsername().isEmpty();
    }

    public static void logOut(){
        loggedInUser = new User();
    }

    public static void setLoggedInUser(User user){
        loggedInUser = user;
    }

    public static User getLoggedInUser(){
        return loggedInUser;
    }
}

package com.ijustspent.main.models;


import com.budgetmaster.main.models.security.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class BaseDocument implements Serializable {

    @Id
    @Getter
    String id;

    @Getter
    Date createStamp;

    @Getter
    @Setter
    protected String version;

    @Getter
    String documentType;

    @Getter
    @Setter
    protected User user;

    @Getter
    private SortedMap<Date, User> updateByUsers;

    protected BaseDocument(){

        this.createStamp = new Date();
        this.documentType = this.getClass().getCanonicalName();
        this.updateByUsers = new TreeMap<>();

    }

    public void addToUpdateByUsers(User user){
        this.updateByUsers.put(new Date(), user);
    }

}

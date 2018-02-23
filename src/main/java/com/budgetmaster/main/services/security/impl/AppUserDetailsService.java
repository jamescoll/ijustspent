package com.budgetmaster.main.services.security.impl;

import com.budgetmaster.main.models.security.MongoUserDetails;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mongodb.client.model.Filters;


import org.bson.Document;

import java.util.List;

@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private MongoClient mongoClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("**********************************************");
        MongoDatabase database = mongoClient.getDatabase("budget");
        System.out.println(database.toString());
        MongoCollection<Document> collection = database.getCollection("mongouserdetails");
        System.out.println(collection.toString());
        //todo review this.. i think the simple repo object should give us this
        Document document = collection.find(Filters.eq("username", username)).first();
        System.out.println(document.toString());
        if(document!=null) {
            //String username = document.getString("username");
            String password = document.getString("password");
            List<String> authorities = (List<String>) document.get("authorities");
            MongoUserDetails mongoUserDetails = new MongoUserDetails(username, password,authorities.toArray(new String[authorities.size()]));
            return mongoUserDetails;
        }
        System.out.println("Got here");
        return null;

    }
}

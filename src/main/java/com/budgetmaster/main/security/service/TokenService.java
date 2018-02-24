package com.budgetmaster.main.security.service;


public interface TokenService {

    String getToken(String username, String password);
}

package com.budgetmaster.main.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Getter
@Setter
class AccountCredentials {

    private String username;
    private String password;
   //private List<GrantedAuthority> authorities;
}

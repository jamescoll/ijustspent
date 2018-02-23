package com.budgetmaster.main.models.security;

import com.budgetmaster.main.models.BaseDocument;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "mongouserdetails")
public class MongoUserDetails extends BaseDocument implements UserDetails  {

    @Getter
    private String username;
    @Getter
    private String password;
    private List<GrantedAuthority> authorities;

    public MongoUserDetails(String username, String password, String[] authorities) {
        this.username = username;
        this.password = password;
        this.authorities = AuthorityUtils.createAuthorityList(authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
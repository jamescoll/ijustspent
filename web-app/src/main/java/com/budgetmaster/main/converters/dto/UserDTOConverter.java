package com.budgetmaster.main.converters.dto;

import com.budgetmaster.main.dto.UserDTO;
import com.budgetmaster.main.models.security.Authority;
import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.security.helpers.PasswordHelper;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;


public class UserDTOConverter implements Converter<UserDTO, User> {

    @Override
    public User convert(final UserDTO dto) {
        final User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAccountNonExpired(false);
        user.setCredentialsNonExpired(false);
        user.setEnabled(true);

        //todo this is added just to push in a default role
        //the fix here is to pass in authorities for a user in the dto
        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.ROLE_USER);
        user.setAuthorities(authorities);
        return user;
    }
}

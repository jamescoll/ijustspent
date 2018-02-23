package com.budgetmaster.main.models.security;

import com.budgetmaster.main.models.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "users")
public class User extends BaseDocument{

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<Role> roles;

    public void addRole(Role role){ this.roles.add(role); }
}

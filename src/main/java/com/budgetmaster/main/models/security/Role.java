package com.budgetmaster.main.models.security;

import com.budgetmaster.main.models.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "roles")
public class Role extends BaseDocument {

    private String roleName;
    private String description;
}

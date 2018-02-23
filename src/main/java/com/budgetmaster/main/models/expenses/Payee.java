package com.budgetmaster.main.models.expenses;

import lombok.*;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode
@ToString
public class Payee {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String description;

    public Payee(String description) {
        this.description = description;
    }
}

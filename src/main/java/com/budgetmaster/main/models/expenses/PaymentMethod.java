package com.budgetmaster.main.models.expenses;

import lombok.*;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode
@ToString
public class PaymentMethod {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String description;

    public PaymentMethod(String description) {
        this.description = description;
    }
}

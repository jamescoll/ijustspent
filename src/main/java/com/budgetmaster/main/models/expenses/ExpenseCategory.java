package com.budgetmaster.main.models.expenses;

import lombok.*;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode
@ToString
public class ExpenseCategory {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String categoryName;

    public ExpenseCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}

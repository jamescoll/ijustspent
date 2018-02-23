package com.budgetmaster.main.models.expenses;

import lombok.*;
import org.springframework.data.annotation.Id;

@EqualsAndHashCode
@ToString
public class ExpenseSubcategory {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String subcategoryName;

    @Getter
    @Setter
    private ExpenseCategory categoryName;

    public ExpenseSubcategory(String subcategoryName, ExpenseCategory categoryName) {
        this.subcategoryName = subcategoryName;
        this.categoryName = categoryName;
    }
}

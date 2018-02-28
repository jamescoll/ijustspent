package com.budgetmaster.main.models.expenses;

import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.models.resources.Icon;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


//@EqualsAndHashCode
@ToString
@Document(collection = "expensesubcategories")
@Getter
@Setter
@AllArgsConstructor
public class ExpenseSubcategory extends BaseDocument {

    private String subcategoryName;
    private ExpenseCategory expenseCategory;
    private Icon icon;

    {
        this.version = "1";
    }
}

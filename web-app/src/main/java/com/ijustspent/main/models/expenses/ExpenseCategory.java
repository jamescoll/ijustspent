package com.ijustspent.main.models.expenses;

import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.models.resources.Icon;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

//@EqualsAndHashCode
@ToString
@Document(collection = "expensecategories")
@Getter
@Setter
@AllArgsConstructor
public class ExpenseCategory extends BaseDocument {

    private String categoryName;
    private Icon icon;

    {
        this.version = "1";
    }
}

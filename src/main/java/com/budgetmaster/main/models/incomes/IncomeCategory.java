package com.budgetmaster.main.models.incomes;


import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.models.resources.Icon;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "incomecategories")
@Getter
@Setter
@AllArgsConstructor
public class IncomeCategory extends BaseDocument {

    private String categoryName;
    private Icon icon;

}

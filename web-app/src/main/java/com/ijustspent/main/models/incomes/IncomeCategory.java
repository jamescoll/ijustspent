package com.ijustspent.main.models.incomes;


import com.ijustspent.main.models.BaseDocument;
import com.ijustspent.main.models.resources.Icon;
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

    {
        this.version = "1";
    }

}

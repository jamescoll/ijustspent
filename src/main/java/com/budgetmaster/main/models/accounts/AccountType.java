package com.budgetmaster.main.models.accounts;


import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.models.resources.Icon;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "accounttypes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountType extends BaseDocument {

    private String type;
    private Icon icon;

}

package com.budgetmaster.main.models.expenses;

import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.security.helpers.UserHelper;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "payees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payee extends BaseDocument {

    private String name;
    private String accountNumber;
    private String phoneNumber;
    private String website;
    private String note;

    {
        this.version = "1";

    }

}

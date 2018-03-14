package com.ijustspent.main.models.accounts;

import com.ijustspent.main.models.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseDocument {

    private String name;
    private AccountType accountType;
    private Date asOfDate;
    private boolean includeInTotals;

    {
        this.version = "1";
    }

}

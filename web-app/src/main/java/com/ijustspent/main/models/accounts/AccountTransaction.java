package com.ijustspent.main.models.accounts;


import com.ijustspent.main.models.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "accounttransactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountTransaction extends BaseDocument {

    private Account account;
    private BigDecimal amount;
    private Date transactionDate;

    {
        this.version = "1";
    }

}

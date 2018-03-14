package com.ijustspent.main.models.incomes;

import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.models.accounts.Account;
import com.ijustspent.main.models.accounts.Account;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "incomes")
@Getter
@Setter
@AllArgsConstructor
public class Income extends BaseDocument {

    private IncomeCategory incomeCategory;
    private Date date;
    private BigDecimal amount;
    private Account account;
    private String note;

    {
        this.version = "1";
    }

}

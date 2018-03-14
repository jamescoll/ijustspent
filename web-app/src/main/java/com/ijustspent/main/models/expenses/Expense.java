package com.ijustspent.main.models.expenses;

import com.ijustspent.main.models.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;


@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "expenses")
@Getter
@Setter
@AllArgsConstructor
public class Expense extends BaseDocument {

    private Date date;
    private ExpenseCategory expenseCategory;
    private BigDecimal amount;
    private Payee payee;
    private String note;

    {
        this.version = "1";

    }

}

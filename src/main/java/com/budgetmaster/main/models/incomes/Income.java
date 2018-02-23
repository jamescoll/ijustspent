package com.budgetmaster.main.models.incomes;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@EqualsAndHashCode
@ToString
@Document(collection = "incomes")
public class Income {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private BigDecimal amount;

    @Getter
    @Setter
    private String note;

    @Getter
    @Setter
    private IncomeCategory incomeCategory;

    //TODO push this into a currency class
    @Getter
    @Setter
    private String currency;
}

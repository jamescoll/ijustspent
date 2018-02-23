package com.budgetmaster.main.models.expenses;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;


@EqualsAndHashCode
@ToString
public class Expense {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    private ExpenseCategory expenseCategory;

    @Getter
    @Setter
    private ExpenseSubcategory expenseSubcategory;

    @Getter
    @Setter
    private BigDecimal amount;

    @Getter
    @Setter
    private Payee payee;

    @Getter
    @Setter
    private Note note;

    //TODO push this into a currency class
    @Getter
    @Setter
    private String currency;

    public Expense(Date date, ExpenseCategory expenseCategory, ExpenseSubcategory expenseSubcategory, BigDecimal amount, Payee payee, Note note, String currency) {
        this.date = date;
        this.expenseCategory = expenseCategory;
        this.expenseSubcategory = expenseSubcategory;
        this.amount = amount;
        this.payee = payee;
        this.note = note;
        this.currency = currency;
    }


}

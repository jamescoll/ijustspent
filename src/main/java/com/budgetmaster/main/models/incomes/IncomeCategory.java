package com.budgetmaster.main.models.incomes;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode
@ToString
@Document(collection = "incomes")
public class IncomeCategory {

    @Id
    @Getter
    private String id;

    @Getter
    @Setter
    private String categoryName;


}

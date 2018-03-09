package com.budgetmaster.main.models.demo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ExpenseTotal {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int total;


}

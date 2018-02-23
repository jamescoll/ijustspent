package com.budgetmaster.main.models.deleteme;

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

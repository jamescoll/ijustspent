package com.budgetmaster.main.models.expenses;

import com.budgetmaster.main.models.BaseDocument;
import com.budgetmaster.main.models.resources.Icon;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = false)
@ToString
@Document(collection = "paymentmethods")
@AllArgsConstructor
@Getter
@Setter
public class PaymentMethod extends BaseDocument {

    private String description;
    private Icon icon;

}

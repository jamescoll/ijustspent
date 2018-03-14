package com.ijustspent.main.models.expenses;

import com.ijustspent.main.models.BaseDocument;
import com.ijustspent.main.models.resources.Icon;
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

    {
        this.version = "1";
    }

}

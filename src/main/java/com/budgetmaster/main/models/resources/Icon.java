package com.budgetmaster.main.models.resources;


import com.budgetmaster.main.models.BaseDocument;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
@Setter
@AllArgsConstructor
@Document(collection = "icons")
public class Icon extends BaseDocument {

    private String iconName;
    private String iconCategory;
    private String iconLocation;

    {
        this.version = "1";
    }

}

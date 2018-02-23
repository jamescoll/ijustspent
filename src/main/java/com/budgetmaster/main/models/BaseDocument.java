package com.budgetmaster.main.models;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.annotation.Id;


import java.util.Date;

public abstract class BaseDocument {

    @Id
    @Getter
    String id;

    @Getter
    final Date createStamp = new Date();

    @Getter
    final String schemaVersion = "1.0.0";

    @Getter
    final String partitionKey = "1";

    @Getter
    final private String documentType = this.getClass().getSimpleName();


}

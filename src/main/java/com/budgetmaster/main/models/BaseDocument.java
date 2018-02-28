package com.budgetmaster.main.models;


import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.security.helpers.UserHelper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class BaseDocument implements Serializable {

    @Id
    @Getter
    String id;

    @Getter
    Date createStamp;

    @Getter
    @Setter
    protected String version;

    @Getter
    String documentType;

    @Getter
    @Setter
    protected User user;

    protected BaseDocument(){

        this.createStamp = new Date();
        this.documentType = this.getClass().getSimpleName();

    }


}

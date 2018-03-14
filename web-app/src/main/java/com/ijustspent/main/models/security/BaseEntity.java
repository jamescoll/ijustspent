package com.ijustspent.main.models.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@Document
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 8571261118900116242L;

    @Id
    @Getter
    private String id;
    @Getter
    @Setter
    private String createdAt;
    @Getter
    @Setter
    private String updatedAt;

}

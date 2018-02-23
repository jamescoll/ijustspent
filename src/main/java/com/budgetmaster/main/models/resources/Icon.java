package com.budgetmaster.main.models.resources;


import lombok.Getter;
import org.springframework.data.annotation.Id;


import java.util.Date;

public abstract class Icon {

  @Id
  @Getter
  String id;

  @Getter
  Date createStamp = new Date();

  //todo find out why these guys don't work - something to do with how @value works
  @Getter
  //@Value("${homebudget.schemaversion}")
  String schemaVersion = "2.0.0";


  //todo find out what this guy is
  @Getter
 // @Value("${homebudget.partitionkey}")
  String partitionKey = "1";

  @Getter
  private String documentType = this.getClass().getName();



}

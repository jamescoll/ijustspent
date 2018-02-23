package com.budgetmaster.main;


import com.budgetmaster.main.models.security.MongoUserDetails;
import com.budgetmaster.main.models.security.Role;
import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import com.budgetmaster.main.repositories.security.RoleRepository;
import com.budgetmaster.main.repositories.security.MongoUserDetailsRepository;
import com.budgetmaster.main.services.TestDataPopulatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    TestDataPopulatorService testDataPopulatorService;

    @Autowired
    PayeeRepository payeeRepository;

    @Autowired
    MongoUserDetailsRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public static void main(String[] args) {


        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

      String[] roles = {"ADMIN_USER", "STANDARD_USER"};


        userRepository.save(new MongoUserDetails("admin", "password", roles));

        String[] rolesB = {"STANDARD_USER"};


        userRepository.save(new MongoUserDetails("standard", "password", rolesB));

        //userRepository.save(new User("admin", "password", "First", "Last", roles));
        //payeeRepository.save(new Payee("Tom Jones", "1234-4321-1234-4321", "212-2345432", "www.tj.com", "Note about TJ account"));*/

   /* Account account = new Account("account", new AccountType("location", new Icon("icon.png", "banking", "/usr/resource/")), new Date(), true);

    System.out.println("****************************" + account.getPartitionKey());
    System.out.println("****************************" + account.getSchemaVersion());
    System.out.println("****************************" + account.getCreateStamp());
    System.out.println("****************************" + account.getDocumentType());
    System.out.println("****************************" + account.getName());
    System.out.println("****************************" + account.toString());

    accountRepository.save(account);

    List<Account> accounts = accountRepository.findBySchemaVersion("1.0.0");

    for(Account a:accounts){
      System.out.println("****************************" + a.toString());
    }*/

        //testDataPopulatorService.putRepositoryData();

        //testDataPopulatorService.testQueryDateRange();

        //testDataPopulatorService.testCompoundQuery();

        //expenseService.getExpenseTotalsForYear(2016);
        // testDataPopulatorService.putRepositoryData();

    }
}
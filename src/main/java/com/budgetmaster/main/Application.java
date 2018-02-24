package com.budgetmaster.main;

import com.budgetmaster.main.models.security.Authority;
import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.repositories.security.UserRepository;
import com.budgetmaster.main.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
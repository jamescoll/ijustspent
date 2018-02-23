package com.budgetmaster.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.Payee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PayeeRepository extends MongoRepository<Payee, String> {

}

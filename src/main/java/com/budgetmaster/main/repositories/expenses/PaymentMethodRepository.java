package com.budgetmaster.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.PaymentMethod;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {

}

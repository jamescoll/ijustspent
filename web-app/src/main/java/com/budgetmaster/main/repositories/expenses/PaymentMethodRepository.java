package com.budgetmaster.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.PaymentMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {

}
package com.ijustspent.main.repositories.expenses;

import com.ijustspent.main.models.expenses.PaymentMethod;
import com.ijustspent.main.models.expenses.PaymentMethod;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends MongoRepository<PaymentMethod, String> {

}

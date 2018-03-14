package com.ijustspent.main.repositories.expenses;

import com.ijustspent.main.models.expenses.Payee;
import com.ijustspent.main.models.expenses.Payee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayeeRepository extends MongoRepository<Payee, String> {
    List<Payee> findByName(String name);
}

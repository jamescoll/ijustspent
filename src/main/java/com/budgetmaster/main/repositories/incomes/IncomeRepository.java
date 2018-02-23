package com.budgetmaster.main.repositories.incomes;

import com.budgetmaster.main.models.incoming.Income;
import com.budgetmaster.main.models.incoming.IncomeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeRepository extends MongoRepository<Income, String> {

    Income findByIncomeCategory(IncomeCategory incomeCategory);
}

package com.budgetmaster.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.ExpenseSubcategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseSubcategoryRepository extends MongoRepository<ExpenseSubcategory, String> {
    
}

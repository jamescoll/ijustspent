package com.budgetmaster.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String> {

    ExpenseCategory findByCategoryName(String categoryName);
}

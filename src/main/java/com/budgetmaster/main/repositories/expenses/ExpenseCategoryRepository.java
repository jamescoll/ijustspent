package com.budgetmaster.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String> {

    public ExpenseCategory findByCategoryName(String categoryName);
}

package com.budgetmaster.main.repositories.expenses;


import com.budgetmaster.main.models.expenses.Expense;
import com.budgetmaster.main.models.expenses.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    public Expense findByExpenseCategory(ExpenseCategory expenseCategory);

}

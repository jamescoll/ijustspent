package com.ijustspent.main.repositories.expenses;

import com.budgetmaster.main.models.expenses.ExpenseCategory;
import com.budgetmaster.main.models.expenses.ExpenseSubcategory;
import com.ijustspent.main.models.expenses.ExpenseCategory;
import com.ijustspent.main.models.expenses.ExpenseSubcategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseSubcategoryRepository extends MongoRepository<ExpenseSubcategory, String> {

    List<ExpenseSubcategory> findByExpenseCategory(ExpenseCategory expenseCategory);

    ExpenseSubcategory findBySubcategoryName(String subcategoryName);

}

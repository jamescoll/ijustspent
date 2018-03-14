package com.ijustspent.main.repositories.expenses;


import com.budgetmaster.main.models.expenses.Expense;
import com.budgetmaster.main.models.expenses.ExpenseCategory;
import com.budgetmaster.main.models.expenses.Payee;
import com.ijustspent.main.models.expenses.Expense;
import com.ijustspent.main.models.expenses.ExpenseCategory;
import com.ijustspent.main.models.expenses.Payee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {

    //todo read this https://stackoverflow.com/questions/33494444/mongorepository-findbycreatedatbetween-not-returning-accurate-results

    List<Expense> findByExpenseCategory(ExpenseCategory expenseCategory);

    List<Expense> findByDateBetween(Date d1, Date d2);

    List<Expense> findByAmountLessThan(BigDecimal amount);

    List<Expense> findByAmountGreaterThan(BigDecimal amount);

    List<Expense> findByAmountBetween(BigDecimal amount1, BigDecimal amount2);

    List<Expense> findByPayee(Payee payee);

    List<Expense> findByAmountLessThanAndExpenseCategory(BigDecimal amount, ExpenseCategory expenseCategory);

}

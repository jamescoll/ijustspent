package com.budgetmaster.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.expenses.Expense;
import com.budgetmaster.main.repositories.expenses.ExpenseCategoryRepository;
import com.budgetmaster.main.repositories.expenses.ExpenseRepository;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import com.budgetmaster.main.services.LoggedInUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseController extends BaseController {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    LoggedInUserService loggedInUserService;

    @Autowired
    PayeeRepository payeeRepository;

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExpenses() {

        return ok(expenseRepository.findAll());

    }

    @RequestMapping(value = "/expenses/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExpense(@PathVariable String id) {

        return ok(expenseRepository.findById(id));

    }


    @RequestMapping(value = "/expenses/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createExpense(@RequestBody Expense expense) {
        expense.setUser(loggedInUserService.getLoggedInUser());
        expense.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(expenseRepository.save(expense));
    }

    @RequestMapping(value = "/expenses/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteExpense(@PathVariable String id) {

        expenseRepository.deleteById(id);
        return ok();

    }

    @RequestMapping(value = "/expenses", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteExpenses() {

        expenseRepository.deleteAll();
        return ok();

    }

    @RequestMapping(value = "/expenses", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateExpense(@RequestBody Expense expense) {
        expense.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(expenseRepository.save(expense));

    }


}
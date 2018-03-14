package com.ijustspent.main.controllers.expenses;

import com.ijustspent.main.controllers.BaseController;
import com.ijustspent.main.models.expenses.Expense;
import com.ijustspent.main.repositories.expenses.ExpenseCategoryRepository;
import com.ijustspent.main.repositories.expenses.ExpenseRepository;
import com.ijustspent.main.repositories.expenses.PayeeRepository;
import com.ijustspent.main.services.LoggedInUserService;
import com.ijustspent.main.models.expenses.Expense;
import com.ijustspent.main.repositories.expenses.ExpenseCategoryRepository;
import com.ijustspent.main.repositories.expenses.ExpenseRepository;
import com.ijustspent.main.repositories.expenses.PayeeRepository;
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


    @RequestMapping(value = "/expenses", method = RequestMethod.POST, consumes = "application/json")
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

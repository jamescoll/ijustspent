package com.ijustspent.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.expenses.ExpenseCategory;
import com.budgetmaster.main.repositories.expenses.ExpenseCategoryRepository;
import com.budgetmaster.main.repositories.resources.IconRepository;
import com.ijustspent.main.models.expenses.ExpenseCategory;
import com.ijustspent.main.repositories.expenses.ExpenseCategoryRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseCategoryController extends BaseController {


    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    IconRepository iconRepository;


    @RequestMapping(value = "/expensecategories", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExpenseCategories() {

        return ok(expenseCategoryRepository.findAll());

    }

    @RequestMapping(value = "/expensecategories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExpenseCategory(@PathVariable String id) {

        return ok(expenseCategoryRepository.findById(id));

    }


    @RequestMapping(value = "/expensecategories", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {

        return ok(expenseCategoryRepository.save(expenseCategory));
    }

    @RequestMapping(value = "/expensecategories/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteExpenseCategory(@PathVariable String id) {

        expenseCategoryRepository.deleteById(id);
        return ok();

    }

    @RequestMapping(value = "/expensecategories", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteExpenseCategories() {

        expenseCategoryRepository.deleteAll();
        return ok();

    }

    @RequestMapping(value = "/expensecategories", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateExpenseCategory(@RequestBody ExpenseCategory expenseCategory) {

        return ok(expenseCategoryRepository.save(expenseCategory));

    }
}

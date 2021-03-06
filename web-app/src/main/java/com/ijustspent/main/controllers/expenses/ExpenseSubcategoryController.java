package com.ijustspent.main.controllers.expenses;

import com.ijustspent.main.controllers.BaseController;
import com.ijustspent.main.models.expenses.ExpenseSubcategory;
import com.ijustspent.main.repositories.expenses.ExpenseCategoryRepository;
import com.ijustspent.main.repositories.expenses.ExpenseSubcategoryRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import com.ijustspent.main.models.expenses.ExpenseSubcategory;
import com.ijustspent.main.repositories.expenses.ExpenseCategoryRepository;
import com.ijustspent.main.repositories.expenses.ExpenseSubcategoryRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class ExpenseSubcategoryController extends BaseController {


    @Autowired
    ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    IconRepository iconRepository;

    @Autowired
    ExpenseSubcategoryRepository expenseSubcategoryRepository;

    @RequestMapping(value = "/expensesubcategories", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExpenses() {

        return ok(expenseSubcategoryRepository.findAll());

    }

    @RequestMapping(value = "/expensesubcategories/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getExpenseSubcategory(@PathVariable String id) {

        return ok(expenseSubcategoryRepository.findById(id));

    }


    @RequestMapping(value = "/expensesubcategories", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createExpenseSubcategory(@RequestBody ExpenseSubcategory expenseSubcategory) {

        return ok(expenseSubcategoryRepository.save(expenseSubcategory));
    }

    @RequestMapping(value = "/expensesubcategories/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteExpenseSubcategory(@PathVariable String id) {

        expenseSubcategoryRepository.deleteById(id);
        return ok();

    }

    @RequestMapping(value = "/expensesubcategories", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteExpenseSubcategories() {

        expenseSubcategoryRepository.deleteAll();
        return ok();

    }

    @RequestMapping(value = "/expensesubcategories", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateExpenseSubcategory(@RequestBody ExpenseSubcategory expenseSubcategory) {


        return ok(expenseSubcategoryRepository.save(expenseSubcategory));

    }
}

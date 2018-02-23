package com.budgetmaster.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.repositories.incomes.IncomeCategoryRepository;
import com.budgetmaster.main.repositories.incomes.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ExpenseCategoryController extends BaseController {


    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;

    @RequestMapping(value="/income")
    @ResponseBody
    public ResponseEntity<?> getIncomes(){

        return ok(incomeRepository.findAll());

    }

    @RequestMapping(value="/income/{incomeCategory}")
    @ResponseBody
    public ResponseEntity<?> getIncomesByIncomeCategory(@PathVariable String incomeCategory){

        //todo null checks here
        return ok(incomeRepository.findByIncomeCategory(incomeCategoryRepository.findByCategoryName(incomeCategory)));

    }
}

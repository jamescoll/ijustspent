package com.ijustspent.main.controllers.incomes;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.incomes.Income;
import com.budgetmaster.main.repositories.accounts.AccountRepository;
import com.budgetmaster.main.repositories.incomes.IncomeCategoryRepository;
import com.budgetmaster.main.repositories.incomes.IncomeRepository;
import com.budgetmaster.main.services.LoggedInUserService;
import com.ijustspent.main.models.incomes.Income;
import com.ijustspent.main.repositories.accounts.AccountRepository;
import com.ijustspent.main.repositories.incomes.IncomeCategoryRepository;
import com.ijustspent.main.repositories.incomes.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class IncomeController extends BaseController {

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    LoggedInUserService loggedInUserService;

    @RequestMapping(value = "/incomes", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIncomes() {

        return ok(incomeRepository.findAll());

    }

    @RequestMapping(value = "/incomes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getIncome(@PathVariable String id) {

        return ok(incomeRepository.findById(id));

    }

    @RequestMapping(value = "/incomes", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createIncome(@RequestBody Income income) {
        income.setUser(loggedInUserService.getLoggedInUser());
        income.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(incomeRepository.save(income));

    }

    @RequestMapping(value = "/incomes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIncome(@PathVariable String id) {

        incomeRepository.deleteById(id);

        return ok();

    }

    @RequestMapping(value = "/incomes", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIncomes() {

        incomeRepository.deleteAll();

        return ok();

    }

    @RequestMapping(value = "/incomes", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateIncome(@RequestBody Income income) {

        income.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(incomeRepository.save(income));

    }
}

package com.budgetmaster.main.controllers.incomes;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.incomes.Income;
import com.budgetmaster.main.repositories.accounts.AccountRepository;
import com.budgetmaster.main.repositories.incomes.IncomeCategoryRepository;
import com.budgetmaster.main.repositories.incomes.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class IncomeController extends BaseController {

    /*
     private IncomeCategory incomeCategory;
    private Date date;
    private BigDecimal amount;
    private Account account;
    private String note;
     */

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    IncomeCategoryRepository incomeCategoryRepository;

    @Autowired
    AccountRepository accountRepository;

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

        return ok(incomeRepository.save(income));

    }

    @RequestMapping(value = "/incomes/incomecategory/{categoryId}/account/{accountId}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createIncomeWithCategoryAndAccount(
            @PathVariable String categoryId,
            @PathVariable String accountId,
            @RequestBody Income income) {

        incomeCategoryRepository.findById(categoryId).ifPresent(income::setIncomeCategory);
        accountRepository.findById(accountId).ifPresent(income::setAccount);

        return ok(incomeRepository.save(income));

    }

    @RequestMapping(value = "/incomes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIncome(@PathVariable String id) {

        incomeRepository.deleteById(id);

        //todo fix all of these in delete as we don't want to be returning emptiness
        return ok();

    }

    //todo we probably don't want to expose the nuclear option as a REST endpoint
    @RequestMapping(value = "/incomes", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteIncomes() {

        incomeRepository.deleteAll();

        return ok();

    }

    @RequestMapping(value = "/incomes/incomecategory/{categoryId}/account/{accountId}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateIncome(
            @PathVariable String categoryId,
            @PathVariable String accountId,
            @RequestBody Income income) {

        incomeCategoryRepository.findById(categoryId).ifPresent(income::setIncomeCategory);
        accountRepository.findById(accountId).ifPresent(income::setAccount);

        return ok(incomeRepository.save(income));

    }
}

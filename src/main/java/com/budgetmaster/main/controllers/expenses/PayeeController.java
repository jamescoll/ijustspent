package com.budgetmaster.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.expenses.Payee;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
public class PayeeController extends BaseController {

    @Autowired
    PayeeRepository payeeRepository;

    @RequestMapping(value = "/payees")
    @ResponseBody
    public ResponseEntity<?> getExpenses() {
        return ok(payeeRepository.findAll());
    }

    @RequestMapping(value = "/payee")
    @ResponseBody
    public ResponseEntity<?> getExpense(@RequestParam(value = "id", defaultValue = "") String id) {
        return ok(payeeRepository.findById(id));
    }

    @RequestMapping(value = "/payee", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> addPayee(@RequestBody Payee payee) {

        return ok(payeeRepository.save(payee));
    }
}

package com.ijustspent.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.expenses.Payee;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import com.budgetmaster.main.services.LoggedInUserService;
import com.ijustspent.main.models.expenses.Payee;
import com.ijustspent.main.repositories.expenses.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1")
public class PayeeController extends BaseController {

    @Autowired
    PayeeRepository payeeRepository;

    @Autowired
    LoggedInUserService loggedInUserService;

    @RequestMapping(value = "/payees", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPayees() {
        return ok(payeeRepository.findAll());
    }

    @RequestMapping(value = "/payees/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPayee(@PathVariable String id) {

        return ok(payeeRepository.findById(id));

    }

    @RequestMapping(value = "/payees", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createPayee(@RequestBody Payee payee) {
        payee.setUser(loggedInUserService.getLoggedInUser());
        payee.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return created(payeeRepository.save(payee));
    }

    @RequestMapping(value = "/payees", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> updatePayee(@RequestBody Payee payee) {
        payee.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(payeeRepository.save(payee));
    }

    @RequestMapping(value = "/payees/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePayee(@PathVariable String id) {

        payeeRepository.deleteById(id);
        return accepted();
    }

    @RequestMapping(value = "/payees", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePayees() {

        payeeRepository.deleteAll();
        return accepted();
    }

}

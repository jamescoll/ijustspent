package com.budgetmaster.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.expenses.Payee;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api/v1")
public class PayeeController extends BaseController {

    @Autowired
    PayeeRepository payeeRepository;

    @RequestMapping(value = "/payees", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPayees() {
        return ok(payeeRepository.findAll());
    }

    @RequestMapping(value = "/payees/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPayee(@PathVariable String id) {

        Optional<Payee> payee = payeeRepository.findById(id);

        if(payee.isPresent()){
            return ok(payee);
        } else {
            return notFound();
        }

    }

    @RequestMapping(value = "/payees", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createPayee(@RequestBody Payee payee) {

        return created(payeeRepository.save(payee));
    }

    @RequestMapping(value = "/payees", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> updatePayee(@RequestBody Payee payee) {

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

    //todo review this approach for validation
    private boolean validatePayee(Payee payee) {
        return (payee.getName() != null && payee.getAccountNumber() != null && payee.getPhoneNumber() != null);
    }

}

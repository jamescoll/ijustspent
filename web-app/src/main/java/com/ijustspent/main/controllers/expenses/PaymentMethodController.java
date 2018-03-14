package com.ijustspent.main.controllers.expenses;

import com.budgetmaster.main.controllers.BaseController;
import com.budgetmaster.main.models.expenses.PaymentMethod;
import com.budgetmaster.main.repositories.expenses.PaymentMethodRepository;
import com.budgetmaster.main.repositories.resources.IconRepository;
import com.ijustspent.main.models.expenses.PaymentMethod;
import com.ijustspent.main.repositories.expenses.PaymentMethodRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentMethodController extends BaseController {


    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Autowired
    IconRepository iconRepository;


    @RequestMapping(value = "/paymentmethods", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPaymentMethods() {
        return ok(paymentMethodRepository.findAll());
    }

    @RequestMapping(value = "/paymentmethods/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getPaymentMethod(@PathVariable String id) {
        return ok(paymentMethodRepository.findById(id));
    }

    @RequestMapping(value = "/paymentmethods", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createPaymentMethod(@RequestBody PaymentMethod payee) {

        return ok(paymentMethodRepository.save(payee));
    }

    @RequestMapping(value = "/paymentmethods", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> updatePaymentMethod(@RequestBody PaymentMethod payee) {

        return ok(paymentMethodRepository.save(payee));
    }

    @RequestMapping(value = "/paymentmethods/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePaymentMethod(@PathVariable String id) {

        paymentMethodRepository.deleteById(id);
        return ok();
    }

    @RequestMapping(value = "/paymentmethods", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deletePaymentMethods() {

        paymentMethodRepository.deleteAll();
        return ok();
    }
}

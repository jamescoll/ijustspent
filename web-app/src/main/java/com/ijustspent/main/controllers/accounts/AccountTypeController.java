package com.ijustspent.main.controllers.accounts;

import com.ijustspent.main.controllers.BaseController;
import com.ijustspent.main.models.accounts.AccountType;
import com.ijustspent.main.repositories.accounts.AccountTypeRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import com.ijustspent.main.models.accounts.AccountType;
import com.ijustspent.main.repositories.accounts.AccountTypeRepository;
import com.ijustspent.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class AccountTypeController extends BaseController {


    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Autowired
    IconRepository iconRepository;

    @RequestMapping(value = "/accounttypes", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAccountTypes() {

        return ok(accountTypeRepository.findAll());

    }

    @RequestMapping(value = "/accounttypes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAccountType(@PathVariable String id) {

        return ok(accountTypeRepository.findById(id));

    }

    @RequestMapping(value = "/accounttypes", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createAccountType(
            @RequestBody AccountType accountType
    ) {
        return ok(accountTypeRepository.save(accountType));
    }

    @RequestMapping(value = "/accounttypes/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteAccountType(@PathVariable String id) {

        accountTypeRepository.deleteById(id);
        return ok();

    }

    @RequestMapping(value = "/accounttypes", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteAccountTypes() {

        accountTypeRepository.deleteAll();
        return ok();

    }

    @RequestMapping(value = "/accounttypes", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateAccountType(
            @RequestBody AccountType accountType) {

        return ok(accountTypeRepository.save(accountType));

    }


}

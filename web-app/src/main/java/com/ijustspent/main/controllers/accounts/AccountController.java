package com.ijustspent.main.controllers.accounts;

import com.ijustspent.main.controllers.BaseController;
import com.ijustspent.main.models.accounts.Account;
import com.ijustspent.main.repositories.accounts.AccountRepository;
import com.ijustspent.main.repositories.accounts.AccountTypeRepository;
import com.ijustspent.main.services.LoggedInUserService;
import com.ijustspent.main.models.accounts.Account;
import com.ijustspent.main.repositories.accounts.AccountRepository;
import com.ijustspent.main.repositories.accounts.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class AccountController extends BaseController {


    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    LoggedInUserService loggedInUserService;

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAccounts() {
        return ok(accountRepository.findAll());
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAccount(@PathVariable String id) {
        return ok(accountRepository.findById(id));
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
        account.setUser(loggedInUserService.getLoggedInUser());
        account.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(accountRepository.save(account));
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> updateAccount(@RequestBody Account account) {
        account.addToUpdateByUsers(loggedInUserService.getLoggedInUser());
        return ok(accountRepository.save(account));
    }

    @RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteAccount(@PathVariable String id) {
        //todo add logic preventing a user from deleting an account which they did not create
        accountRepository.deleteById(id);
        return ok();
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteAccounts() {

        accountRepository.deleteAll();
        return ok();
    }
}

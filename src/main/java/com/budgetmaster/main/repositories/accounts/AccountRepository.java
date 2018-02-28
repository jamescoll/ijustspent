package com.budgetmaster.main.repositories.accounts;

import com.budgetmaster.main.models.accounts.Account;
import com.budgetmaster.main.models.accounts.AccountType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByAccountType(AccountType accountType);

    Account findByName(String name);

    List<Account> findByIncludeInTotals(boolean includeInTotals);


}

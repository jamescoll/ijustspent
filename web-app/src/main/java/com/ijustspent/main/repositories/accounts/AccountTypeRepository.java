package com.ijustspent.main.repositories.accounts;

import com.budgetmaster.main.models.accounts.AccountType;
import com.ijustspent.main.models.accounts.AccountType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends MongoRepository<AccountType, String> {

}

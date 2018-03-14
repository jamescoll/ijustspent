package com.ijustspent.main.repositories.accounts;

import com.ijustspent.main.models.accounts.Account;
import com.ijustspent.main.models.accounts.AccountTransaction;
import com.ijustspent.main.models.accounts.Account;
import com.ijustspent.main.models.accounts.AccountTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface AccountTransactionRepository extends MongoRepository<AccountTransaction, String> {

    List<AccountTransaction> findByTransactionDate(Date date);

    List<AccountTransaction> findByAccount(Account account);

    List<AccountTransaction> findByAmount(BigDecimal amount);

    List<AccountTransaction> findByAmountLessThan(BigDecimal amount);

    List<AccountTransaction> findByAmountGreaterThan(BigDecimal amount);

    List<AccountTransaction> findByAmountBetween(BigDecimal amount1, BigDecimal amount2);
}

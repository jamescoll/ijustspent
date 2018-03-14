package com.ijustspent.main.repositories.incomes;

import com.ijustspent.main.models.incomes.Income;
import com.ijustspent.main.models.incomes.IncomeCategory;
import com.ijustspent.main.models.incomes.Income;
import com.ijustspent.main.models.incomes.IncomeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends MongoRepository<Income, String> {

    Income findByIncomeCategory(IncomeCategory incomeCategory);
}

package com.budgetmaster.main.repositories.incomes;


import com.budgetmaster.main.models.incoming.IncomeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IncomeCategoryRepository extends MongoRepository<IncomeCategory, String> {
    IncomeCategory findByCategoryName(String categoryName);
}

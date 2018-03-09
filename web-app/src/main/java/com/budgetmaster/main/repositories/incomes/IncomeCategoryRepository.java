package com.budgetmaster.main.repositories.incomes;


import com.budgetmaster.main.models.incomes.IncomeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeCategoryRepository extends MongoRepository<IncomeCategory, String> {
    IncomeCategory findByCategoryName(String categoryName);
}

package com.ijustspent.main.repositories.incomes;


import com.ijustspent.main.models.incomes.IncomeCategory;
import com.ijustspent.main.models.incomes.IncomeCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeCategoryRepository extends MongoRepository<IncomeCategory, String> {
    IncomeCategory findByCategoryName(String categoryName);
}

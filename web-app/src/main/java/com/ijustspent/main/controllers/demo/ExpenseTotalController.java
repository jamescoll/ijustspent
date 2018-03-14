package com.ijustspent.main.controllers.demo;

import com.budgetmaster.main.models.demo.ExpenseTotal;
import com.google.common.collect.Maps;
import com.ijustspent.main.models.demo.ExpenseTotal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ExpenseTotalController {

    private static final Map<String, ExpenseTotal> EXPENSETOTALS = Maps.newHashMap();
    private static final List<ExpenseTotal> EXPENSETOTALSLIST;

    static {
        EXPENSETOTALS.put("food", new ExpenseTotal("food", 200));
        EXPENSETOTALS.put("rent", new ExpenseTotal("rent", 1100));
        EXPENSETOTALS.put("petrol", new ExpenseTotal("petrol", 200));
        EXPENSETOTALS.put("entertainment", new ExpenseTotal("entertainment", 75));
        EXPENSETOTALS.put("insurance", new ExpenseTotal("insurance", 350));
        EXPENSETOTALS.put("other", new ExpenseTotal("other", 45));
        EXPENSETOTALS.put("phone", new ExpenseTotal("phone", 50));
        EXPENSETOTALS.put("tobacco", new ExpenseTotal("tobacco", 50));
        EXPENSETOTALS.put("clothes", new ExpenseTotal("clothes", 50));
        EXPENSETOTALSLIST = new ArrayList<ExpenseTotal>(EXPENSETOTALS.values());
    }

    @GetMapping("/api/expensetotals/{description}")
    public ExpenseTotal getExpenseTotal(@PathVariable(value = "description") String description) {
        return EXPENSETOTALS.get(description);
    }

    @GetMapping("/api/expensetotals/")
    public List<ExpenseTotal> getExpenseTotals() {
        return EXPENSETOTALSLIST;
    }
}

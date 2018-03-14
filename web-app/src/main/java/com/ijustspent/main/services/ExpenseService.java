package com.ijustspent.main.services;

import com.budgetmaster.main.repositories.expenses.ExpenseRepository;
import com.ijustspent.main.repositories.expenses.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;

@Service
public class ExpenseService {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // static HashMap<String, ExpenseByMonth> expenseByMonthHashMap;

    static {
        //  expenseByMonthHashMap = new HashMap<String, ExpenseByMonth>();
    }

    @Autowired
    ExpenseRepository expenseRepository;
    String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    //todo handle exception here properly

   /* public HashMap<String, ExpenseByMonth> getExpenseTotalsForYear(int year) throws Exception{

        for(int i=1; i<13; i++){
            List<Expense> expensesInMonth =  expenseRepository.findByDateBetween(getBeginDateMonthYear(i, 2017), getEndDateMonthYear(i, 2017));

            ExpenseByMonth expenseByMonth = new ExpenseByMonth();
            expenseByMonth.setExpenseMonth(months[i-1]);

            HashMap<ExpenseCategory, BigDecimal> totalsByCategory = new HashMap<>();

            BigDecimal totalAmount = BigDecimal.ZERO;
            int numberOfExpensesInMonth = 0;

            for(Expense expense: expensesInMonth){
                totalAmount = totalAmount.add(expense.getAmount());
                numberOfExpensesInMonth++;
                if(totalsByCategory.containsKey(expense.getExpenseCategory())){
                    BigDecimal amount = totalsByCategory.get(expense.getExpenseCategory()).add(expense.getAmount());
                    totalsByCategory.replace(expense.getExpenseCategory(), amount);

                } else {
                    totalsByCategory.put(expense.getExpenseCategory(), expense.getAmount());
                }
            }

            expenseByMonth.setExpenseMonth(months[i-1]);
            expenseByMonth.setTotalByCategory(totalsByCategory);
            expenseByMonth.setOverallTotal(totalAmount);
            expenseByMonth.setNumberOfExpenses(numberOfExpensesInMonth);

        }

        System.out.println("Breakpoint");

        return expenseByMonthHashMap;
    }*/

    public static Date getBeginDateMonthYear(int month, int year) throws Exception {

        String sMonth = getMonthString(month);
        return sdf.parse("01/" + sMonth + "/" + year);

    }

    private static String getMonthString(int month) {
        String sMonth = String.valueOf(month);

        if (month < 10) {
            sMonth = "0" + String.valueOf(month);
        }
        return sMonth;
    }

    private static String getDayString(int day) {
        String sDay = String.valueOf(day);

        if (day < 10) {
            sDay = "0" + String.valueOf(sDay);
        }
        return sDay;
    }

    public static Date getEndDateMonthYear(int month, int year) throws Exception {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        String sDay = getDayString(yearMonthObject.lengthOfMonth());
        String sMonth = getMonthString(month);
        return sdf.parse(sDay + "/" + sMonth + "/" + year);
    }


}

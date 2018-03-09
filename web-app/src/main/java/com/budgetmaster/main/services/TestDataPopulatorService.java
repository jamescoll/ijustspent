package com.budgetmaster.main.services;

import com.budgetmaster.main.models.accounts.Account;
import com.budgetmaster.main.models.accounts.AccountTransaction;
import com.budgetmaster.main.models.accounts.AccountType;
import com.budgetmaster.main.models.expenses.*;
import com.budgetmaster.main.models.incomes.Income;
import com.budgetmaster.main.models.incomes.IncomeCategory;
import com.budgetmaster.main.models.resources.Icon;
import com.budgetmaster.main.repositories.accounts.AccountRepository;
import com.budgetmaster.main.repositories.accounts.AccountTransactionRepository;
import com.budgetmaster.main.repositories.accounts.AccountTypeRepository;
import com.budgetmaster.main.repositories.expenses.*;
import com.budgetmaster.main.repositories.incomes.IncomeCategoryRepository;
import com.budgetmaster.main.repositories.incomes.IncomeRepository;
import com.budgetmaster.main.repositories.resources.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


//todo this is just for testing purposes and will be killed once something better comes along
@Service
public class TestDataPopulatorService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    private ExpenseSubcategoryRepository expenseSubcategoryRepository;

    @Autowired
    private PayeeRepository payeeRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private IncomeCategoryRepository incomeCategoryRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private IconRepository iconRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoOperations mongoOperation;


    private void populateIcons() {
        String location = "/usr/resources";

        for (int i = 0; i < 50; i++) {
            iconRepository.save(new Icon(getRandomIconName(), getRandomIconCategory(), location));
        }

    }

    private void populateIncomeCategories() {

        String location = "/usr/resources";

        Icon icon = iconRepository.save(new Icon(getRandomIconName(), getRandomIconCategory(), location));

        for (int i = 0; i < 10; i++) {
            incomeCategoryRepository.save(new IncomeCategory(getRandomIncomeCategory(), icon));
        }
    }

    private void populateAccountTypes() {
        List<Icon> icons = iconRepository.findAll();

        for (int i = 0; i < 10; i++) {
            accountTypeRepository.save(new AccountType("Savings", icons.get(i)));
        }

    }

    private void populateAccounts() {

        List<AccountType> accountTypes = accountTypeRepository.findAll();

        for (int i = 0; i < 10; i++) {
            accountRepository.save(new Account(getRandomAccountName(), accountTypes.get(i), new Date(), true));
        }
    }

    private void populateIncomes() {
        List<IncomeCategory> incomeCategories = incomeCategoryRepository.findAll();
        List<Account> accounts = accountRepository.findAll();

        for (int i = 0; i < 10; i++) {
            incomeRepository.save(new Income(incomeCategories.get(i), new Date(), getRandomBigDecimal(), accounts.get(i), getRandomNote()));
        }
    }

    private void populateExpenseCategories() {
        List<Icon> icons = iconRepository.findAll();

        for (int i = 0; i < 10; i++) {
            expenseCategoryRepository.save(new ExpenseCategory(getRandomExpenseCategory(), icons.get(i)));
        }
    }

    private void populateExpenseSubCategories() {
        List<Icon> icons = iconRepository.findAll();
        List<ExpenseCategory> expenseCategories = expenseCategoryRepository.findAll();

        for (int i = 0; i < 10; i++) {
            expenseSubcategoryRepository.save(new ExpenseSubcategory(getRandomExpenseSubCategory(), expenseCategories.get(i), icons.get(i)));
        }
    }

    private void populatePayees() {
        payeeRepository.save(new Payee("Tom", "123123123", "8912323123", "www.tom.com", "Note about Tom"));
    }

    private void populateExpenses() {

        /*
          private Date date;
    private ExpenseCategory expenseCategory;
    private BigDecimal amount;
    private Payee payee;
    private String note;
         */

        List<ExpenseCategory> expenseCategories = expenseCategoryRepository.findAll();
        //todo this isn't null safe fix it
        Payee payee = payeeRepository.findByName("Tom").get(0);

        for (int i = 0; i < 10; i++) {
            expenseRepository.save(new Expense(
                    new Date(),
                    expenseCategories.get(i),
                    getRandomBigDecimal(),
                    payee,
                    "this is a note about the expense"
            ));

        }
    }

    private void populatePaymentMethods() {
        List<Icon> icons = iconRepository.findAll();

        for (int i = 0; i < 10; i++) {
            paymentMethodRepository.save(new PaymentMethod("Payment method", icons.get(i)));
        }

    }

    private void populateAccountTransactions() {
        List<Account> accounts = accountRepository.findAll();

        for (int i = 0; i < 100; i++) {

            accountTransactionRepository.save(new AccountTransaction(accounts.get(i % 10), getRandomBigDecimal(), new Date()));
        }

    }


    public void putRepositoryData() throws Exception {

        iconRepository.deleteAll();
        incomeCategoryRepository.deleteAll();
        accountTypeRepository.deleteAll();
        accountRepository.deleteAll();
        incomeRepository.deleteAll();
        expenseCategoryRepository.deleteAll();
        expenseSubcategoryRepository.deleteAll();
        payeeRepository.deleteAll();
        expenseRepository.deleteAll();
        paymentMethodRepository.deleteAll();
        accountTransactionRepository.deleteAll();

        populateIcons();
        populateIncomeCategories();
        populateAccountTypes();
        populateAccounts();
        populateIncomes();
        populateExpenseCategories();
        populateExpenseSubCategories();
        populatePayees();
        populateExpenses();
        populatePaymentMethods();
        populateAccountTransactions();

    }


    private Date getRandomDateInRange(Date d1, Date d2) {
        return new Date(ThreadLocalRandom.current().nextLong(d1.getTime(), d2.getTime()));

    }

    private String getRandomExpenseCategory() {
        String[] list = {"Rent", "Vehicle", "Food", "Entertainment", "Vehicle", "Utilities", "Medical"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRandomIconCategory() {
        String[] list = {"Rent", "Vehicle", "Food", "Entertainment", "Vehicle", "Utilities", "Medical"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRandomIncomeCategory() {
        String[] list = {"Salary", "Bonus", "Contract Work", "Tax Rebate", "Dividend", "Claim"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private BigDecimal getRandomBigDecimal() {
        return generateRandomAmountFromRange(new BigDecimal(50.00), new BigDecimal(400.00));
    }

    private String getRandomIconName() {
        String[] list = {"x1.png", "x2.png", "x3.png", "x4.png", "x5.png", "x6.png", "x7.png"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRandomExpenseSubCategory() {
        String[] list = {"Sub1", "Sub2", "Sub3", "Sub4", "Sub5", "Sub6", "Sub7"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRandomPayee() {
        String[] list = {"Landlord", "Lidl", "Marks and Spencer", "Liberty Insurance", "AIB", "Aramco", "Custom House Medical"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRandomNote() {
        String[] list = {"Paid in cash", "Bank transfer", "Paid with cash and card"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRandomAccountName() {
        String[] list = {"Ulster Bank", "TSB", "Credit Union", "Friends First"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private BigDecimal generateRandomAmountFromRange(BigDecimal min, BigDecimal max) {
        BigDecimal randomBigDecimal = min.add(new BigDecimal(Math.random()).multiply(max.subtract(min)));
        return randomBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    //todo put this badboy into a custom query class and cf http://www.baeldung.com/queries-in-spring-data-mongodb for more related goodness
    public void testQueryDateRange() throws Exception {
        //db.expense.find({ date: { $gte:ISODate("2018-02-19T14:00:00Z"), $lt: ISODate("2018-03-19T20:00:00Z") } })
        /*BasicQuery query = new BasicQuery("{ date: { $gte:ISODate(\"2018-02-19T14:00:00Z\"), $lt: ISODate(\"2018-02-27T20:00:00Z\") } }");
        List<Expense> expenses = mongoOperation.find(query, Expense.class);

        for(Expense e: expenses){
            System.out.println(e.toString());
        }*/
        // query.addCriteria(Criteria.where("age").lt(50).gt(20));
        //List<User> users = mongoTemplate.find(query,User.class);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = sdf.parse("01/01/2018");
        Date d2 = sdf.parse("01/02/2018");


        List<Expense> expenses = expenseRepository.findByDateBetween(d1, d2);

        for (Expense e : expenses) {
            System.out.println(e.toString());
        }

    }

    public void testCompoundQuery() {
        List<Expense> expenses = expenseRepository.findByAmountLessThanAndExpenseCategory(new BigDecimal(200.00), expenseCategoryRepository.findByCategoryName("Rent"));

        for (Expense e : expenses) {
            System.out.println(e.toString());
        }
    }


}

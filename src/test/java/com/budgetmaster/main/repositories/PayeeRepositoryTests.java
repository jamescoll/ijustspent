package com.budgetmaster.main.repositories;

import com.budgetmaster.main.Application;
import com.budgetmaster.main.models.expenses.Payee;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
"spring.data.mongodb.database=test"
}, classes = Application.class)
public class PayeeRepositoryTests {

    //todo note for repositories tests only check methods extended in repo - in this case findByName

    @Autowired
    PayeeRepository payeeRepository;

    @Before
    public void setUp()  {

        this.payeeRepository.deleteAll();

        payeeRepository.save(new Payee("Tom Jones", "1234-4321-1234-4321", "212-2345432", "www.tj.com", "Note about TJ account"));
        payeeRepository.save(new Payee("Tom Jones", "123123", "212-23245432", "www.thomasj.com", "Note about TJ lorem lipsum"));
        payeeRepository.save(new Payee("Broderick", "12344321", "212-2345432", "www.broderick.com", "Note about Broderick account"));

    }

    @Test
    public void testFindByMultipleEntries(){

        List<Payee> payeeList = payeeRepository.findByName("Tom Jones");
        assertTrue(payeeList.size() == 2);
    }

    @Test
    public void testFindByNameSingleEntry(){

        List<Payee> payeeList = payeeRepository.findByName("Tom Jones");
        assertTrue(payeeList.size() == 2);
    }

    @Test
    public void testFindByNameNotPresent(){
        List<Payee> payeeList = payeeRepository.findByName("Stanley Toms");

        assertTrue(payeeList.isEmpty());
    }

    @After
    public void clearUp()  {

        this.payeeRepository.deleteAll();

    }

}
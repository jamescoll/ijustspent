package com.ijustspent.main.config;


import com.ijustspent.main.Application;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "spring.data.mongodb.database=test"
}, classes = Application.class)
@WebAppConfiguration
public class CorsFilterTest extends TestCase {


   //https://stackoverflow.com/questions/11451917/how-do-i-unit-test-a-servlet-filter-with-junit
    //todo this contains no methods
}

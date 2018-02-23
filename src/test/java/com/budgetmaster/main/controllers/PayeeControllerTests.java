package com.budgetmaster.main.controllers;

import com.budgetmaster.main.Application;
import com.budgetmaster.main.models.expenses.Payee;
import com.budgetmaster.main.repositories.expenses.PayeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
"spring.data.mongodb.database=test"
}, classes = Application.class)
@WebAppConfiguration
public class PayeeControllerTests {

    @Autowired
    private PayeeRepository payeeRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private Payee payee;

    private List<Payee> payeeList = new ArrayList<>();

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
        .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
        .findAny()
        .orElse(null);

        assertNotNull("the JSON message converter must not be null",
        this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.payeeRepository.deleteAll();

        payee = payeeRepository.save(new Payee("Tom Jones", "1234-4321-1234-4321", "212-2345432", "www.tj.com", "Note about TJ account"));
        payeeList.add(payeeRepository.save(new Payee("Tate and Sons", "4234-4321-4234-4321", "101-2345432", "www.tateandsons.com", "Note about tate account")));
        payeeList.add(payeeRepository.save(new Payee("Bank Co", "5234-5321-5234-5321", "333-2345432", "www.bankco.com", "Note about bank co")));
    }

    @Test
    public void readSinglePayee() throws Exception {
        mockMvc.perform(get("/api/v1/payees/" + payee.getId()))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.id", is(this.payee.getId())))
        .andExpect(jsonPath("$.createStamp", is(this.payee.getCreateStamp().getTime())))
        .andExpect(jsonPath("$.schemaVersion", is(this.payee.getSchemaVersion())))
        .andExpect(jsonPath("$.partitionKey", is(this.payee.getPartitionKey())))
        .andExpect(jsonPath("$.name", is(this.payee.getName())))
        .andExpect(jsonPath("$.accountNumber", is(this.payee.getAccountNumber())))
        .andExpect(jsonPath("$.phoneNumber", is(this.payee.getPhoneNumber())))
        .andExpect(jsonPath("$.website", is(this.payee.getWebsite())))
        .andExpect(jsonPath("$.note", is(this.payee.getNote())));
    }

    //todo implement these and add fields cf https://spring.io/guides/tutorials/bookmarks/
    //see also here for repository testing http://www.baeldung.com/spring-boot-testing

    @Test
    public void readPayees() throws Exception {
        mockMvc.perform(get("/api/v1/payees/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$", hasSize(3)))
        .andExpect(jsonPath("$[0].id", is(payee.getId())))
        .andExpect(jsonPath("$[1].id", is(this.payeeList.get(0).getId())))
        .andExpect(jsonPath("$[2].id", is(this.payeeList.get(1).getId())));
    }

    @Test
    public void createPayee() throws Exception {

        String payeeJson = json(new Payee("Bob Wilson", "3456-3456-1234-4321", "111-2345432", "www.bw.com", "Note about BW account"));

        mockMvc.perform(post("/api/v1/payees/")
        .contentType(contentType)
        .content(payeeJson))
        .andExpect(status().isCreated());

    }

    @Test
    public void updatePayee() throws Exception {

        payee.setName("Mary");
        payee.setAccountNumber("123123");

        String payeeJson = json(payee);

        mockMvc.perform(put("/api/v1/payees/")
        .contentType(contentType)
        .content(payeeJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.id", is(this.payee.getId())))
        .andExpect(jsonPath("$.createStamp", is(this.payee.getCreateStamp().getTime())))
        .andExpect(jsonPath("$.schemaVersion", is(this.payee.getSchemaVersion())))
        .andExpect(jsonPath("$.partitionKey", is(this.payee.getPartitionKey())))
        .andExpect(jsonPath("$.name", is("Mary")))
        .andExpect(jsonPath("$.accountNumber", is("123123")))
        .andExpect(jsonPath("$.phoneNumber", is(this.payee.getPhoneNumber())))
        .andExpect(jsonPath("$.website", is(this.payee.getWebsite())))
        .andExpect(jsonPath("$.note", is(this.payee.getNote())));

    }

    @Test
    public void deletePayee() throws Exception {

        mockMvc.perform(delete("/api/v1/payees/" + payee.getId()))
        .andExpect(status().isAccepted());

        mockMvc.perform(get("/api/v1/payees/" + payee.getId()))
        .andExpect(status().isNotFound());

    }

    //cf https://softwareengineering.stackexchange.com/questions/203492/when-to-use-http-status-code-404-in-an-api

    @Test
    public void deletePayees() throws Exception {

        mockMvc.perform(delete("/api/v1/payees/"))
        .andExpect(status().isAccepted());

        mockMvc.perform(get("/api/v1/payees/"))
        .andExpect(content().string("[]"));

    }

    @SuppressWarnings("unchecked")
    private String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
        o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

    @After
    public void clearUp() {
        this.payeeRepository.deleteAll();
    }
}
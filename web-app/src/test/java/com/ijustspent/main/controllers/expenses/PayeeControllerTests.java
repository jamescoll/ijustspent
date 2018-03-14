package com.ijustspent.main.controllers.expenses;

import com.ijustspent.main.Application;
import com.ijustspent.main.dto.LoginDTO;
import com.ijustspent.main.models.expenses.Payee;
import com.ijustspent.main.models.security.Authority;
import com.ijustspent.main.models.security.User;
import com.ijustspent.main.repositories.expenses.PayeeRepository;
import com.ijustspent.main.repositories.security.UserRepository;
import com.ijustspent.main.services.LoggedInUserService;
import com.ijustspent.main.services.UserService;
import org.json.JSONObject;
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
import org.springframework.test.web.servlet.MvcResult;
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
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private UserService userService;

    @Autowired
    private LoggedInUserService loggedInUserService;


    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private Payee payee;

    private List<Payee> payeeList = new ArrayList<>();

    private User testUser;

    private String token;


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
        clearAndCreatePayeeData();
        clearAndCreateTestUser();
        authenticateTestUser();

    }

    private void clearAndCreatePayeeData() {
        this.payeeRepository.deleteAll();

        payee = payeeRepository.save(new Payee("Tom Jones", "1234-4321-1234-4321", "212-2345432", "www.tj.com", "Note about TJ account"));
        payeeList.add(payeeRepository.save(new Payee("Tate and Sons", "4234-4321-4234-4321", "101-2345432", "www.tateandsons.com", "Note about tate account")));
        payeeList.add(payeeRepository.save(new Payee("Bank Co", "5234-5321-5234-5321", "333-2345432", "www.bankco.com", "Note about bank co")));
    }

    private void clearAndCreateTestUser() {

        this.userRepository.deleteAll();

        testUser = new User();

        testUser.setUsername("TestUser");
        testUser.setPassword("TestPassword");
        testUser.setEnabled(true);
        testUser.setCredentialsNonExpired(true);
        testUser.setAccountNonLocked(true);
        List<Authority> authorities = new ArrayList<>();
        authorities.add(Authority.ROLE_USER);
        testUser.setAuthorities(authorities);
        testUser.setAccountNonExpired(true);

        testUser = this.userService.create(testUser);
    }

    private void authenticateTestUser() throws Exception {
        String userDTOJson = json(new LoginDTO("TestUser", "TestPassword"));

        MvcResult postResult = mockMvc.perform(post("/api/auth/")
                .contentType(contentType)
                .content(userDTOJson))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk()).andReturn();

        JSONObject tokenJson = new JSONObject(postResult.getResponse().getContentAsString());
        this.token = tokenJson.getString("token");
    }

    @Test
    public void readSinglePayee() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/payees/" + payee.getId())
                .header("x-auth-token", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.payee.getId())))
                .andExpect(jsonPath("$.createStamp", is(this.payee.getCreateStamp().getTime())))
                .andExpect(jsonPath("$.version", is(this.payee.getVersion())))
                .andExpect(jsonPath("$.name", is(this.payee.getName())))
                .andExpect(jsonPath("$.accountNumber", is(this.payee.getAccountNumber())))
                .andExpect(jsonPath("$.phoneNumber", is(this.payee.getPhoneNumber())))
                .andExpect(jsonPath("$.website", is(this.payee.getWebsite())))
                .andExpect(jsonPath("$.note", is(this.payee.getNote()))).andReturn();

    }

    @Test
    public void readSinglePayeeWithUserInformationAttached() throws Exception {

        String payeeJsonPayload = json(new Payee("Brian Fitzpatrick", "4321-9999-4321", "01-2345432", "www.bf.com", "Note about BF account"));

        MvcResult payeeCreateResult = mockMvc.perform(post("/api/v1/payees/")
                .header("x-auth-token", this.token)
                .contentType(contentType)
                .content(payeeJsonPayload))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isCreated()).andReturn();

        JSONObject payeeJsonResponse = new JSONObject(payeeCreateResult.getResponse().getContentAsString());
        String payeeId = payeeJsonResponse.getString("id");
        JSONObject userJsonResponse = payeeJsonResponse.getJSONObject("user");
        String userId = userJsonResponse.getString("id");

        MvcResult result = mockMvc.perform(get("/api/v1/payees/" + payeeId)
                .header("x-auth-token", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(payeeId)))
                .andExpect(jsonPath("$.user.id", is(userId))).andReturn();

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

        //todo add logic in this test for the updated user appearing in the treemap...

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
                .andExpect(jsonPath("$.version", is(this.payee.getVersion())))
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
        this.userRepository.deleteAll();

    }
}
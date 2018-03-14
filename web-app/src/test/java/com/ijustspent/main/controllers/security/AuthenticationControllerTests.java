package com.ijustspent.main.controllers.security;

import com.budgetmaster.main.Application;
import com.budgetmaster.main.dto.LoginDTO;
import com.budgetmaster.main.dto.UserDTO;
import com.budgetmaster.main.models.security.Authority;
import com.budgetmaster.main.models.security.User;
import com.budgetmaster.main.repositories.security.UserRepository;
import com.budgetmaster.main.security.helpers.PasswordHelper;
import com.budgetmaster.main.security.service.TokenService;
import com.budgetmaster.main.services.UserService;
import com.ijustspent.main.Application;
import com.ijustspent.main.dto.LoginDTO;
import com.ijustspent.main.dto.UserDTO;
import com.ijustspent.main.repositories.security.UserRepository;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
        "spring.data.mongodb.database=test"
}, classes = Application.class)
@WebAppConfiguration
public class AuthenticationControllerTests {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private TokenService tokenService;

    private User testUser;



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

        this.userService.create(testUser);


    }

    @Test
    public void testAuthenticateBasic() throws Exception{
        String userDTOJson = json(new LoginDTO("TestUser", "TestPassword"));

       mockMvc.perform(post("/api/auth/")
                .contentType(contentType)
                .content(userDTOJson))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk());

    }

    @Test
    public void testAuthenticateTokenAndSecureURL() throws Exception{
        String userDTOJson = json(new UserDTO("TestUser", "TestPassword"));

        MvcResult postResult = mockMvc.perform(post("/api/auth/")
                .contentType(contentType)
                .content(userDTOJson))
                .andExpect(content().contentType(contentType))
                .andExpect(status().isOk())
                .andReturn();

        JSONObject tokenJson = new JSONObject(postResult.getResponse().getContentAsString());
        String token = tokenJson.getString("token");

        MvcResult getResult = mockMvc.perform(get("/api/hello")
                .header("x-auth-token", token))
                .andExpect(status().isOk())
                .andReturn();

        String content = getResult.getResponse().getContentAsString();

        assertEquals(content, "Secured hello!");
    }

    @Test
    public void testAuthenticateFailed() throws Exception {

        String userDTOJson = json(new UserDTO("BadUser", "BadPassword"));

        mockMvc.perform(post("/api/auth/")
                .contentType(contentType)
                .content(userDTOJson))
                .andExpect(status().isBadRequest());

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
        this.userRepository.deleteAll();
    }


}

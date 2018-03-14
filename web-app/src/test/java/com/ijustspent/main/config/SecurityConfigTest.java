package com.ijustspent.main.config;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class SecurityConfigTest {

    private MockMvc mockMvc;

    //https://stackoverflow.com/questions/30420576/testing-websecurityconfigureradapter
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {

        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        mockMvc = MockMvcBuilders.webAppContextSetup( webApplicationContext )
                .addFilter( new CorsFilter(), "/*" )
                .build();
    }

    @Test
    public void testOptions() throws Exception {
        //todo this is currently failing - work out why
        mockMvc.perform( options( "/" ) )
                .andExpect( status().is2xxSuccessful() )
                .andExpect( header().string( "Access-Control-Allow-Origin", notNullValue() ) )
                .andExpect( header().string( "Access-Control-Allow-",
                        equalToIgnoringCase( "POST, GET, PUT, OPTIONS, DELETE" ) ) )
                .andExpect( header().string( "Access-Control-Allow-Headers",
                        equalToIgnoringCase( "content-type, x-auth-token, x-requested-with" ) ) )
                .andExpect( header().string( "Access-Control-Expose-Headers", equalToIgnoringCase( "Location" ) ) )
                .andExpect( header().string( "Access-Control-Max-Age", notNullValue() ));
    }
}

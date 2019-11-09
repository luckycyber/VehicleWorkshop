package com.grokonez.jwtauthentication;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.chika.model.Customer;



@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJwtAuthenticationApplicationTests {


	    @Autowired
	    private WebApplicationContext ctx; //used to build a MockMvc Object
	    private MockMvc mockMvc;
	    @Before
	    public void setup() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	        //mockMvcBuilders is used to verify the status response code and
	        //response content using mockmvcresultmatchers
	    }
	    @Test
	    public void testGetEmpSuccess() throws URISyntaxException{
	    	RestTemplate restTemplate = new RestTemplate();
	    	final String baseUrl = "http://localhost:8080/cust_id";
	    	URI uri = new URI(baseUrl);
	    	ResponseEntity<Customer> result = restTemplate.getForEntity(uri,  Customer.class);
	    	//check whether request succeed or not
	    	Assert.assertEquals("Chika",  result.getBody().getFirstname());
	    	
	    }
}

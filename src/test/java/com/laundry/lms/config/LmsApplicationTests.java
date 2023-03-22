package com.laundry.lms.config;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class LmsApplicationTests {

    @Value("${local.server.port}")
    public int port;

    @Before
    public void setUpGlobal(){
        RestAssured.port=port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}

//a remainder,,when you writing the restAssured library and it is full of errors,it means you need to import
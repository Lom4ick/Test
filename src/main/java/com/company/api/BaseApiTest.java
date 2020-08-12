package com.company.api;

import org.testng.annotations.BeforeMethod;

import static com.company.api.Endpoints.BASE_URI;
import static io.restassured.RestAssured.baseURI;

public class BaseApiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        baseURI = BASE_URI;
    }
}

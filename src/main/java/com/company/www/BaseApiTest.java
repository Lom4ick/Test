package com.company.www;

import org.testng.annotations.BeforeMethod;

import static com.company.www.Endpoints.BASE_URI;
import static io.restassured.RestAssured.baseURI;

public class BaseApiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        baseURI = BASE_URI;
    }
}

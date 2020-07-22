package com.company.www;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.company.www.Utils.BASE_URI;
import static io.restassured.RestAssured.baseURI;

public class BaseApiTest {

    @BeforeMethod(alwaysRun = true)
    public void setUpMethod() {
        baseURI = BASE_URI;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("!!!");
    }
}

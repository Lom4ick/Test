package com.company.www;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class MyFirstApiTest {


    @Test
    public void verifySomething() {
        // set up our base URI
        baseURI = "https://jsonplaceholder.typicode.com/";

        // send request and verify response
        given().
                when().
                    log().all().
                    get("posts/1").
                then().
                    log().all()
                    .statusCode(200)
                    .header("Content-Type", "application/json; charset=utf-8")
                    .body("userId", equalTo(1));

        // send request and get response
        Response response = given().
                when().
                    log().all().
                    get("posts/1").
                then().
                    log().all()
                    .extract().response();

        Assert.assertEquals(response.jsonPath().get("userId"), 2);
    }


}

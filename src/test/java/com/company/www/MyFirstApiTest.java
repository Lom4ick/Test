package com.company.www;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.company.www.Pathes.BODY;
import static com.company.www.Pathes.NAME;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class MyFirstApiTest extends BaseApiTest {

    private Request request = new Request();

    @Test
    public void verifySomething() {
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

        Assert.assertEquals(response.jsonPath().get("userId"), "1");
    }

    @Test
    public void verifyUser1() {
        Response response = request.getUser(1);
        Assert.assertEquals(response.jsonPath().get(NAME), "Leanne Graham");
    }

    @Test
    public void verifyUser2() {
        Response response = request.getUser(2);
        Assert.assertEquals(response.jsonPath().get(NAME), "Ervin Howell");
    }

    @Test
    public void verifyComment() {
        Response response = request.getComment(1);
        Assert.assertEquals(response.jsonPath().get(BODY), "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium");
    }
}

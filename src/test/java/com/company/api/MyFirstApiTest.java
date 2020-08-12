package com.company.api;

import com.company.api.response.post.Post;
import com.company.api.response.user.User;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        Assert.assertEquals((int) response.jsonPath().get("userId"), 1);
    }

    @Test
    public void verifyUser1() {
        User user = request.getUser(1);
        Assert.assertEquals(user.name, "Leanne Graham");
    }

    @Feature("Users")
    @Test(testName = "Test name: Verify User", description = "Test Description: Verify User")
    public void verifyUser2() {
        User user = request.getUser(2);
        Assert.assertEquals(user.address.city, "Wisokyburgh");
    }

    @Feature("Posts")
    @Test
    public void verifyPost() {
        Post post = request.getPost(1);
        Assert.assertEquals(post.userId, 1);
    }
}

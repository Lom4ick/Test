package com.company.www;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

public class Verify {

    @Step
    public void verifyComment(Response response, String path, String expected) {
        Assert.assertEquals(response.jsonPath().get(path), expected);
    }
}

package com.company.www;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.company.www.Endpoints.*;
import static io.restassured.RestAssured.given;

public class Request {

    @Step("Get a user response with id: {id}")
    public Response getUser(int id) {
        return given().
                when().
                    log().all().
                    get(USERS + id).
                then().
                    log().all().
                    extract().
                response();
    }

    @Step("Get a comment response with id: {id}")
    public Response getComment(int id) {
        return given().
                when().
                    log().all().
                    get(COMMENTS + id).
                then().
                    log().all().
                    extract().
                response();
    }
}

package com.company.www;

import io.restassured.response.Response;

import static com.company.www.Endpoints.*;
import static io.restassured.RestAssured.given;

public class Request {

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

package com.company.api;

import com.company.api.response.post.Post;
import com.company.api.response.user.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.company.api.Endpoints.*;
import static io.restassured.RestAssured.given;

public class Request {

//    @Step("Get a user response with id: {id}")
//    public Response getUser(int id) {
//        return given().
//                when().
//                    log().all().
//                    get(USERS + id).
//                then().
//                    log().all().
//                    extract().
//                response();
//    }

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

    public Post getPost(int id) {
        return given().
                when().
                    log().all().
                    get(POSTS + id).
                then().
                    log().all().
                    extract().
                response()
                    .body().as(Post.class);
    }

    public User getUser(int id) {
        return given().
                when().
                        log().all().
                        get(USERS + id).
                then().
                        log().all().
                        extract().
                response()
                        .body().as(User.class);
    }
}

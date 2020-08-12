package com.company.api.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {

    @JsonProperty("userId")
    public int userId;
    @JsonProperty("id")
    public int id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("body")
    public String body;
}

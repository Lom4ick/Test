package com.company.api.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geo {

    @JsonProperty("lat")
    public String lat;
    @JsonProperty("lng")
    public String lng;
}

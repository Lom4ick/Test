package com.company.api.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company {

    @JsonProperty("name")
    public String name;
    @JsonProperty("catchPhrase")
    public String catchPhrase;
    @JsonProperty("bs")
    public String bs;
}

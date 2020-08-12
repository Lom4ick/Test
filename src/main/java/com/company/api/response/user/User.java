package com.company.api.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("username")
    public String username;
    @JsonProperty("email")
    public String email;
    @JsonProperty("address")
    public Address address;
    @JsonProperty("phone")
    public String phone;
    @JsonProperty("website")
    public String website;
    @JsonProperty("company")
    public Company company;
}

package com.visheshawasthi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {
    private String id;
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private List<State> states;

    public Country(String id, String name, String alpha2Code, String alpha3Code) {
        this.id = id;
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
    }
}

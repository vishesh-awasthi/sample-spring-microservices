package com.visheshawasthi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class State {
    private String id;
    private String name;
    private CountryCode countryCode;
}

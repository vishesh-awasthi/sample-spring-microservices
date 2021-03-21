package com.visheshawasthi.service;

import com.visheshawasthi.exception.CountryNotFoundException;
import com.visheshawasthi.model.Country;

import java.util.List;

public interface CountryService {
    List<Country> getCountries();

    Country getCountryById(String id) throws CountryNotFoundException;

    Country getCountryByName(String name) throws CountryNotFoundException;

    Country getCountryByCode(String alphaCode3, Boolean statesIncluded) throws CountryNotFoundException;

}

package com.visheshawasthi.service;

import com.visheshawasthi.model.CountryCode;
import com.visheshawasthi.model.State;

import java.util.List;

public interface StateService {
    List<State> getStatesByCountry(CountryCode countryCode);
}

package com.visheshawasthi.service;

import com.visheshawasthi.model.CountryCode;
import com.visheshawasthi.model.State;

import java.util.List;
import java.util.Map;

public interface StateService {
    Map<CountryCode, List<State>> getStates();

    List<State> getStatesByCountry(CountryCode countryCode);
}

package com.visheshawasthi.service;

import com.visheshawasthi.client.StateClient;
import com.visheshawasthi.exception.CountryNotFoundException;
import com.visheshawasthi.model.Country;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private StateClient stateClient;

    private List<Country> getCountryList() {
        return List.of(
                new Country(UUID.randomUUID().toString(), "India", "IN", "IND"),
                new Country(UUID.randomUUID().toString(), "Canada", "CA", "CAN"),
                new Country(UUID.randomUUID().toString(), "Nepal", "NP", "NEL"));
    }


    @Override
    public List<Country> getCountries() {
        log.info("Getting country list ...");
        return Optional.of(getCountryList())
                .orElse(Collections.emptyList());
    }

    /**
     * @param id represents unique uuid
     * @return {@link Country}
     * @throws CountryNotFoundException if country not found
     */
    @Override
    public Country getCountryById(String id) throws CountryNotFoundException {
        log.info("Getting country with id : {} ", id);
        return getCountryList()
                .stream()
                .filter(countries -> countries.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found with id :" + id));
    }

    /**
     * @param name represents country full name
     * @return {@link Country}
     * @throws CountryNotFoundException if country not found
     */
    @Override
    public Country getCountryByName(String name) throws CountryNotFoundException {
        log.info("Getting country with name : {} ", name);
        return getCountryList()
                .stream()
                .filter(countries -> countries.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found with name :" + name));
    }

    /**
     * @param alphaCode3 represents unique country code
     * @return {@link Country}
     * @throws CountryNotFoundException if country not found
     */
    @Override
    public Country getCountryByCode(String alphaCode3, Boolean statesIncluded) throws CountryNotFoundException {
        log.info("Getting country with alphaCode3 : {} ", alphaCode3);
        Country country = getCountryList()
                .stream()
                .filter(countries -> countries.getAlpha3Code().equals(alphaCode3.toUpperCase(Locale.ROOT)))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found with name :" + alphaCode3));
        if (statesIncluded) {
            country.setStates(stateClient.getStates(alphaCode3.toUpperCase(Locale.ROOT)).getBody());
        }
        return country;
    }

}

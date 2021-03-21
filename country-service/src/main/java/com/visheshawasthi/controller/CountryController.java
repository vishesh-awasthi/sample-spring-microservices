package com.visheshawasthi.controller;

import com.visheshawasthi.exception.CountryNotFoundException;
import com.visheshawasthi.service.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/countries")
@AllArgsConstructor
public class CountryController {

    private CountryService countryService;

    @GetMapping()
    public ResponseEntity getCountries() {
        return new ResponseEntity<>(countryService.getCountries(), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getCountryById(@PathVariable String id) throws CountryNotFoundException {
        return new ResponseEntity<>(countryService.getCountryById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getCountryByName(@PathVariable String name) throws CountryNotFoundException {
        return new ResponseEntity<>(countryService.getCountryByName(name), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity getCountryByCode(@PathVariable String code, @RequestParam(value = "statesIncluded", required = false) boolean statesIncluded) throws CountryNotFoundException {
        return new ResponseEntity<>(countryService.getCountryByCode(code, statesIncluded), HttpStatus.OK);
    }
}

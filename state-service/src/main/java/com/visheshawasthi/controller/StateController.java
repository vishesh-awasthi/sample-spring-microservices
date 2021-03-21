package com.visheshawasthi.controller;

import com.visheshawasthi.model.CountryCode;
import com.visheshawasthi.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/states")
public class StateController {

    private StateService stateService;

    @GetMapping
    public ResponseEntity getStatesByCountryCode(@RequestParam("code") CountryCode alpha3Code) {
        return new ResponseEntity(stateService.getStatesByCountry(alpha3Code), HttpStatus.OK);
    }
}

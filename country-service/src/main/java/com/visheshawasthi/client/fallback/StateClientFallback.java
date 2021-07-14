package com.visheshawasthi.client.fallback;

import com.visheshawasthi.client.StateClient;
import com.visheshawasthi.model.State;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class StateClientFallback implements StateClient {
    @Override
    public ResponseEntity<List<State>> getStates(String alpha3code) {
        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
    }
}

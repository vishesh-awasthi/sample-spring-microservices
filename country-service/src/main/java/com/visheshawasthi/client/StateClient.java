package com.visheshawasthi.client;

import com.visheshawasthi.model.State;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class StateClient {

    @Value("${client.state.url}")
    private String stateClient;

    private final RestTemplate restTemplate;

    public StateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Gets the states.
     *
     * @param countryCode represents country unique aplha3Code.
     * @return {@linl List<State>}
     */
    public List<State> getStates(String countryCode) {
        ResponseEntity<State[]> response = restTemplate.getForEntity(stateClient + countryCode, State[].class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return List.of(response.getBody());
        }
        return null;
    }
}

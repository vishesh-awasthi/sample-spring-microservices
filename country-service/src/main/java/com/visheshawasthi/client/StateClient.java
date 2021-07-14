package com.visheshawasthi.client;

import com.visheshawasthi.client.fallback.StateClientFallback;
import com.visheshawasthi.model.State;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "state-service", fallback = StateClientFallback.class)
public interface StateClient {

    @GetMapping("/state-service/api/v1/states")
    ResponseEntity<List<State>> getStates(@RequestParam("code") String alpha3code);
}

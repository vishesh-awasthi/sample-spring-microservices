package com.visheshawasthi.service;

import com.visheshawasthi.model.CountryCode;
import com.visheshawasthi.model.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class StateServiceImpl implements StateService {

    private final Map<CountryCode, List<State>> states;

    public StateServiceImpl() {
        List<State> indiaStates = List.of(
                new State(UUID.randomUUID().toString(), "Punjab", CountryCode.IND),
                new State(UUID.randomUUID().toString(), "Haryana", CountryCode.IND),
                new State(UUID.randomUUID().toString(), "Tamil Nadu", CountryCode.IND)
        );

        List<State> canadaStates = List.of(
                new State(UUID.randomUUID().toString(), "Nunavut", CountryCode.CAN),
                new State(UUID.randomUUID().toString(), "Quebec", CountryCode.CAN),
                new State(UUID.randomUUID().toString(), "Ontario", CountryCode.CAN)
        );

        List<State> nepalStates = List.of(
            new State(UUID.randomUUID().toString(), "Arun Kshetra", CountryCode.NPL),
            new State(UUID.randomUUID().toString(), "Janakpur Kshetra", CountryCode.NPL),
            new State(UUID.randomUUID().toString(), "Gandak Kshetra", CountryCode.NPL)
        );
        states = groupStatesByCountry(indiaStates, canadaStates, nepalStates);
    }

    /**
     * get the list of states group by country code.
     *
     * @return {@link List<State>}
     */
    public Map<CountryCode, List<State>> getStates() {
        return states;
    }

    /**
     * @param countryCode represents unique country alpha3Code.
     * @return {@link List<State>}
     */
    @Override
    public List<State> getStatesByCountry(CountryCode countryCode) {
        log.info("Getting states for Country code : {}", countryCode.toString());
        return states.get(countryCode);
    }

    private Map<CountryCode, List<State>> groupStatesByCountry(List<State>... states) {
        return Stream.of(states)
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(State::getCountryCode));
    }
}

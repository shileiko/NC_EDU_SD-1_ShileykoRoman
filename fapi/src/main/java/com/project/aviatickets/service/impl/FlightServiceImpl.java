package com.project.aviatickets.service.impl;

import com.project.aviatickets.models.Flight;
import com.project.aviatickets.models.Response;
import com.project.aviatickets.models.Ticket;
import com.project.aviatickets.service.FlightService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class FlightServiceImpl implements FlightService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<Flight> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        Flight[] flightResponse = restTemplate.getForObject(backendServerUrl + "/api/v1/flightsba", Flight[].class);
        return flightResponse == null ? Collections.emptyList() : Arrays.asList(flightResponse);
    }

    @Override
    public Response save(Flight flight) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/v1/flightsba", flight, Response.class).getBody();
    }

    @Override
    public Flight getById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/v1/flightsba/" + id, Flight.class);
    }

    @Override
    public ResponseEntity delete(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "api/v1/flightsba/" + id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public List<Flight> filter(String departureTimeFromUrl, String departureTimeToUrl, String fromPlace, String toPlace) {
        RestTemplate restTemplate = new RestTemplate();
        Flight[] flightResponse = restTemplate.getForObject(backendServerUrl + "/api/v1/flightsba/filter/" +
                departureTimeFromUrl + "/" + departureTimeToUrl + "/" + fromPlace + "/" + toPlace, Flight[].class);
        return flightResponse == null ? Collections.emptyList() : Arrays.asList(flightResponse);
    }


}

package com.project.aviatickets.service;

import com.project.aviatickets.models.Flight;
import com.project.aviatickets.models.Response;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface FlightService {
    List<Flight> getAll();
    Response save(Flight flight);
    Flight getById(Integer id);
    ResponseEntity delete(Integer id);
    List<Flight> filter(String departureTimeUrl, String fromPlace, String toPlace);
}

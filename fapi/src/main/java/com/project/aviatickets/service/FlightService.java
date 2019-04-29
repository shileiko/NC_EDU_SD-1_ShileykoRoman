package com.project.aviatickets.service;

import com.project.aviatickets.models.Flight;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FlightService {
    List<Flight> getAll();
    Flight save(Flight flight);
    Flight getById(Integer id);
    ResponseEntity delete(Integer id);
}

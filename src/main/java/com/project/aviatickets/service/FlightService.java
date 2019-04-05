package com.project.aviatickets.service;

import com.project.aviatickets.model.Flight;

import java.util.List;

public interface FlightService {
    public Flight getById(Integer id);

    public void save(Flight flight);

    public void delete(Integer id);

    public List<Flight> getAll();
}

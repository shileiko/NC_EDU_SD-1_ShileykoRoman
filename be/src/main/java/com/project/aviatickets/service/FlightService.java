package com.project.aviatickets.service;

import com.project.aviatickets.model.Flight;
import com.project.aviatickets.model.Ticket;

import java.text.ParseException;
import java.util.List;

public interface FlightService {
    public Flight getById(Integer id);

    public void save(Flight flight);

    public void delete(Integer id);

    public List<Flight> getAll();

    List<Flight> filter(String departureTimeFromUrl, String departureTimeToUrl, String fromPlace, String toPlace) throws ParseException;
}

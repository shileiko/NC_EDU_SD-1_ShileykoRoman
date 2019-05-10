package com.project.aviatickets.service.impl;

import com.project.aviatickets.model.Flight;
import com.project.aviatickets.repository.FlightRepository;
import com.project.aviatickets.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight getById(Integer id) {
        return flightRepository.getOne(id);
    }

    @Override
    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void delete(Integer id) {
        flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> filter(String departureTimeUrl, String fromPlace, String toPlace) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        Date departureTime = dateFormat.parse(departureTimeUrl);
        return flightRepository.findFlightByDepartureTimeAndFromPlaceAndToPlace(
                departureTime, toPlace, fromPlace
        );
    }
}

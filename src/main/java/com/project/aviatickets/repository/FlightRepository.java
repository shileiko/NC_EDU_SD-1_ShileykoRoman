package com.project.aviatickets.repository;

import com.project.aviatickets.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findFlightById(Integer id);
    //List<Flight> findFlightByArrivalTimeBetween(Calendar before, Calendar after);
    //List<Flight> findFlightByDepartureTimeBefore(Calendar before, Calendar after);
}

package com.project.aviatickets.repository;

import com.project.aviatickets.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findFlightById(Integer id);

    List<Flight> findFlightByDepartureTimeBetweenAndFromPlaceAndToPlace(Date departureTimeFrom,
                                                                        Date departureTimeTo,
                                                                 @Param("fromPlace") String fromPlace,
                                                                 @Param("toPlace") String toPlace);
}

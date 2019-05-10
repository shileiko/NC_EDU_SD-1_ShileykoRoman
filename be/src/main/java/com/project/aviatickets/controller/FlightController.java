package com.project.aviatickets.controller;

import com.project.aviatickets.model.Flight;
import com.project.aviatickets.service.impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/flightsba")
public class FlightController {
    @Autowired
    private FlightServiceImpl flightService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Flight> getFlight(@PathVariable("id") Integer flightId){
        Flight flight = this.flightService.getById(flightId);

        if (flight == null){
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Flight>(flight, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Flight> deleteFlight(@PathVariable("id") Integer flightId){
        Flight flight = this.flightService.getById(flightId);

        if (flight == null){
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }

        this.flightService.delete(flightId);
        return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Flight> saveFlight(@RequestBody @Valid Flight flight){
        this.flightService.save(flight);
        return new ResponseEntity<Flight>(flight, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = this.flightService.getAll();

        if (flights.isEmpty()){
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }

    @GetMapping("/filter/{date}/{fromPlace}/{toPlace}")
    public ResponseEntity<List<Flight>> filter (@PathVariable("date") String departureTimeUrl,
                                                @PathVariable("fromPlace") String fromPlace,
                                                @PathVariable("toPlace") String toPlace) throws ParseException {
        List<Flight> flights = this.flightService.filter(departureTimeUrl, fromPlace, toPlace);

        if (flights.isEmpty()){
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }
}

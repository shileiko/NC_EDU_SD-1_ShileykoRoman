package com.project.aviatickets.controller;

import com.project.aviatickets.models.Flight;
import com.project.aviatickets.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getById(@PathVariable Integer id){
        return  ResponseEntity.ok(flightService.getById(id));
    }

    @PostMapping
    public ResponseEntity saveFlight(@RequestBody Flight flight){
        return ResponseEntity.ok(flightService.save(flight));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return flightService.delete(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> findAll(){
        return ResponseEntity.ok(flightService.getAll());
    }

    @GetMapping("/filter/{departureTime}/{fromPlace}/{toPlace}")
    public ResponseEntity<List<Flight>> filter (@PathVariable("departureTime") String departureTimeUrl,
                                                @PathVariable("fromPlace") String fromPlace,
                                                @PathVariable("toPlace") String toPlace){
        List<Flight> flights = this.flightService.filter(departureTimeUrl, fromPlace, toPlace);

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }
}

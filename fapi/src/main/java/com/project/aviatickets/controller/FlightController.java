package com.project.aviatickets.controller;

import com.project.aviatickets.models.Flight;
import com.project.aviatickets.models.Response;
import com.project.aviatickets.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public Response saveFlight(@RequestBody Flight flight){
        return flightService.save(flight);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return flightService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> findAll(){
        return ResponseEntity.ok(flightService.getAll());
    }

    @GetMapping("/filter/{departureTimeFrom}/{departureTimeTo}/{fromPlace}/{toPlace}")
    public ResponseEntity<List<Flight>> filter (@PathVariable("departureTimeFrom") String departureTimeFromUrl,
                                                @PathVariable("departureTimeTo") String departureTimeToUrl,
                                                @PathVariable("fromPlace") String fromPlace,
                                                @PathVariable("toPlace") String toPlace){
        List<Flight> flights = this.flightService.filter(departureTimeFromUrl, departureTimeToUrl, fromPlace, toPlace);

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }
}

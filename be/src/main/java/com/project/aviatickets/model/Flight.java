package com.project.aviatickets.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="Flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FromPlace")
    private String fromPlace;

    @Column(name = "ToPlace")
    private String toPlace;

    @Column(name = "DepartureTime")
    private Calendar departureTime;

    @Column(name = "ArrivalTime")
    private Calendar arrivalTime;

    @Column(name = "Transfers")
    private boolean transfers;

    @Column(name = "Aviaoperator")
    private String aviaoperator;

    public Flight() {
    }

    public Flight(String fromPlace, String toPlace, Calendar departureTime, Calendar arrivalTime, boolean transfers, String aviaoperator) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transfers = transfers;
        this.aviaoperator = aviaoperator;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Calendar getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Calendar departureTime) {
        this.departureTime = departureTime;
    }

    public Calendar getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Calendar arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean getTransfers() {
        return transfers;
    }

    public void setTransfers(boolean transfers) {
        this.transfers = transfers;
    }

    public String getAviaperator() {
        return aviaoperator;
    }

    public void setAviaoperator(String aviaoperator) {
        this.aviaoperator = aviaoperator;
    }
}

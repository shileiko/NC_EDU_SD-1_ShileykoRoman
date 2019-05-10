package com.project.aviatickets.models;

import java.util.Date;

public class Flight {
    private int id;
    private String fromPlace;
    private String toPlace;
    private Date departureTime;
    private Date arrivalTime;
    private boolean transfers;
    private String aviacompany;

    public Flight() {
    }

    public Flight(String fromPlace, String toPlace, Date departureTime, Date arrivalTime, boolean transfers, String aviacompany) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transfers = transfers;
        this.aviacompany = aviacompany;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean getTransfers() {
        return transfers;
    }

    public void setTransfers(boolean transfers) {
        this.transfers = transfers;
    }

    public String getAviacompany() {
        return aviacompany;
    }

    public void setAviacompany(String aviacompany) {
        this.aviacompany = aviacompany;
    }
}
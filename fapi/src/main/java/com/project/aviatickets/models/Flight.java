package com.project.aviatickets.models;

import java.util.Date;
import java.util.List;

public class Flight {
    private int id;
    private String fromPlace;
    private String toPlace;
    private Date departureTime;
    private Date arrivalTime;
    private boolean transfers;
    private String aviacompany;
    private int ticketkol;
    private List<Ticket> tickets;

    public Flight() {
    }

    public Flight(String fromPlace, String toPlace, Date departureTime, Date arrivalTime, boolean transfers, String aviacompany, int ticketkol, List<Ticket> tickets) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transfers = transfers;
        this.aviacompany = aviacompany;
        this.ticketkol = ticketkol;
        this.tickets = tickets;
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

    public int getTicketkol() {
        return ticketkol;
    }

    public void setTicketkol(int ticketkol) {
        this.ticketkol = ticketkol;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
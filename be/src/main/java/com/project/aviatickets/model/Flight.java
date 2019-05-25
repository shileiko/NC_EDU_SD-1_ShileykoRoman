package com.project.aviatickets.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Please enter from place")
    @Column(name = "FromPlace")
    private String fromPlace;

    @NotBlank(message = "Please enter to place")
    @Column(name = "ToPlace")
    private String toPlace;

    @Column(name = "DepartureTime")
    private Date departureTime;

    @Column(name = "ArrivalTime")
    private Date arrivalTime;

    @Column(name = "Transfers")
    private boolean transfers;

    @NotBlank(message = "Please enter an aviacompany")
    @Column(name = "Aviaoperator")
    private String aviacompany;

    @JsonIgnore
    @Column(name = "tickets")
    @OneToMany(mappedBy = "flight", cascade=CascadeType.ALL)
    private List<Ticket> tickets;

    @Column(name = "Ticketskol")
    private int ticketskol;

    public Flight() {
    }

    public Flight(int ticketskol, String fromPlace, String toPlace, Date departureTime, Date arrivalTime, boolean transfers, String aviacompany, List<Ticket> tickets) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transfers = transfers;
        this.aviacompany = aviacompany;
        this.tickets = tickets;
        this.ticketskol = ticketskol;
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

    @JsonIgnore
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getTicketskol() {
        return ticketskol;
    }

    public void setTicketskol(int ticketskol) {
        this.ticketskol = ticketskol;
    }
}

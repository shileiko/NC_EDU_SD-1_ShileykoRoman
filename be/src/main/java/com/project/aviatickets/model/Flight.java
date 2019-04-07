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
    private char transfers;

    @Column(name = "Operator")
    private String operator;

    public Flight() {
    }

    public Flight(String fromPlace, String toPlace, Calendar departureTime, Calendar arrivalTime, char transfers, String operator) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.transfers = transfers;
        this.operator = operator;
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

    public char getTransfers() {
        return transfers;
    }

    public void setTransfers(char transfers) {
        this.transfers = transfers;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}

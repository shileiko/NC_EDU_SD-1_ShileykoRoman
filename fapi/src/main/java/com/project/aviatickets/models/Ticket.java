package com.project.aviatickets.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {
    private int id;
    private Flight flight;
    private User user;
    private BigDecimal price;
    private String typeOfSeat;
    private boolean luggage;

    public Ticket() {
    }

    public Ticket(Flight flight, User user, BigDecimal price, String typeOfSeat, boolean luggage) {
        this.flight = flight;
        this.user = user;
        this.price = price;
        this.typeOfSeat = typeOfSeat;
        this.luggage = luggage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTypeOfSeat(String typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }

    public boolean getLuggage() {
        return luggage;
    }

    public void setLuggage(boolean luggage) {
        this.luggage = luggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                luggage == ticket.luggage &&
                Objects.equals(flight, ticket.flight) &&
                Objects.equals(user, ticket.user) &&
                Objects.equals(price, ticket.price) &&
                Objects.equals(typeOfSeat, ticket.typeOfSeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flight, user, price, typeOfSeat, luggage);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", flight=" + flight +
                ", user=" + user +
                ", price=" + price +
                ", typeOfSeat='" + typeOfSeat + '\'' +
                ", luggage=" + luggage +
                '}';
    }
}

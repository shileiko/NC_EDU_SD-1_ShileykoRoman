package com.project.aviatickets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Please enter username")
    @Size(min = 4, max = 15, message = "Invalid username. It must be 4-15 symbols")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Please enter firstname")
    @Column(name = "firstname")
    private String firstname;

    @NotBlank(message = "Please enter surname")
    @Column(name = "surname")
    private String surname;

    @NotBlank(message = "Please enter your password")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "Please enter an email")
    @Email(message = "Please enter a valid email")
    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @Column(name = "tickets")
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

    public User() {
    }

    public User(String username, String firstname, String surname, String password, String email, Role role, List<Ticket> tickets) {
        this.username = username;
        this.firstname = firstname;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.role = role;
        this.tickets = tickets;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(username, user.username) &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(role, user.role) &&
                Objects.equals(tickets, user.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstname, surname, password, email, role, tickets);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", tickets=" + tickets +
                '}';
    }
}

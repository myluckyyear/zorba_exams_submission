package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "passenger")
@Inheritance(strategy = InheritanceType.JOINED)
public class Passengers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private int passengerId;

    private String name;
    private String email;
    private String mobile;
    private String seatNumber;
    private String coachType;

    @ManyToMany(mappedBy = "passengers")
    private List<BookingInformation> bookings;

    // Getters and Setters
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getCoachType() {
        return coachType;
    }

    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    public List<BookingInformation> getBookings() {
        return bookings;
    }

    public void setBookings(List<BookingInformation> bookings) {
        this.bookings = bookings;
    }


}

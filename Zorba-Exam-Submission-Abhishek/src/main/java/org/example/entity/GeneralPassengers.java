package org.example.entity;


import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class GeneralPassengers {

    @org.example.entity.Column(name = "passenger_type")
    private String passengerType = "General"; // default type for General passengers

    // Getters and Setters
    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}


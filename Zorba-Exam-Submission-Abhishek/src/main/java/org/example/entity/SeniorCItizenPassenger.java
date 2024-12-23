package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class SeniorCitizenPassenger extends Passengers {

    private double discount;

    @Column(name = "senior_citizen_id")
    private String seniorCitizenId;

    @Column(name = "passenger_type")
    private String passengerType = "Senior Citizen";

    public double calculateDiscount() {
        if ("Senior Citizen".equals(getPassengerType())) {
            discount = 0.20;  // 20% discount for senior citizens
        }
        return discount;
    }

    // Getters and Setters
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getSeniorCitizenId() {
        return seniorCitizenId;
    }

    public void setSeniorCitizenId(String seniorCitizenId) {
        this.seniorCitizenId = seniorCitizenId;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}
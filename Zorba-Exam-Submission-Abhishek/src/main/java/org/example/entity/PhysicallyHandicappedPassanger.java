package org.example.entity;



import javax.persistence.Entity;
import javax.persistence.Column;

@Entity
public class PhysicallyHandicappedPassenger extends Passengers {

    @Column(name = "proof_of_disability")
    private String proofOfDisability;

    @Column(name = "passenger_type")
    private String passengerType = "Physically Handicapped";

    // Getters and Setters
    public String getProofOfDisability() {
        return proofOfDisability;
    }

    public void setProofOfDisability(String proofOfDisability) {
        this.proofOfDisability = proofOfDisability;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}

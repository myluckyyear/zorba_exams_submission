package org.example.entity;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class SeniorCitizen {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Integer passengerId;
    private String name;
    private String email;
    private Integer mobile;
    private String destination;
    @Column(name = "seat_number")
    private String seatNumber;
    private Integer discount;
    @Column(name = "senior_citizen_id")
    private Integer seniorCitizenId;

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setSeniorCitizenId(Integer seniorCitizenId) {
        this.seniorCitizenId = seniorCitizenId;
    }

    @Override
    public String toString() {
        return "SeniorCitizen{" +
                "passengerId=" + passengerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile=" + mobile +
                ", destination='" + destination + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", discount=" + discount +
                ", seniorCitizenId=" + seniorCitizenId +
                '}';
    }
}

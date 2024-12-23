package org.example.entity;




import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "train")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private int trainId;

    private String trainName;
    private int noOfCoach;
    private String trainStartStation;
    private String trainEndStation;
    private String trainType;
    private String trainWeeklyDaysSchedule;
    private double avgSpeed;
    private double fareCharges;
    private String frequency;
    private String specialCharges;
    private String noOfCities;
    private String typesOfGoods;

    // Many-to-many relationship with Passenger
    @OneToMany(mappedBy = "train")
    private List<Passengers> passengers;

    // Getters and Setters
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getNoOfCoach() {
        return noOfCoach;
    }

    public void setNoOfCoach(int noOfCoach) {
        this.noOfCoach = noOfCoach;
    }

    public String getTrainStartStation() {
        return trainStartStation;
    }

    public void setTrainStartStation(String trainStartStation) {
        this.trainStartStation = trainStartStation;
    }

    public String getTrainEndStation() {
        return trainEndStation;
    }

    public void setTrainEndStation(String trainEndStation) {
        this.trainEndStation = trainEndStation;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getTrainWeeklyDaysSchedule() {
        return trainWeeklyDaysSchedule;
    }

    public void setTrainWeeklyDaysSchedule(String trainWeeklyDaysSchedule) {
        this.trainWeeklyDaysSchedule = trainWeeklyDaysSchedule;
    }

    public double getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(double avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public double getFareCharges() {
        return fareCharges;
    }

    public void setFareCharges(double fareCharges) {
        this.fareCharges = fareCharges;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getSpecialCharges() {
        return specialCharges;
    }

    public void setSpecialCharges(String specialCharges) {
        this.specialCharges = specialCharges;
    }

    public String getNoOfCities() {
        return noOfCities;
    }

    public void setNoOfCities(String noOfCities) {
        this.noOfCities = noOfCities;
    }

    public String getTypesOfGoods() {
        return typesOfGoods;
    }

    public void setTypesOfGoods(String typesOfGoods) {
        this.typesOfGoods = typesOfGoods;
    }
}
}

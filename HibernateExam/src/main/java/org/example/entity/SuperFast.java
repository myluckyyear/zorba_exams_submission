package org.example.entity;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "super_fast")
public class SuperFast {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "train_id")
    private Integer trainId;
    @Column(name = "train_name")
    private String trainName;
    @Column(name = "no_of_coach")
    private Integer noOfCoach;
    @Column(name="train_start_station")
    private String trainStartStation;
    @Column(name = "train_end_station")
    private String trainEndStation;
    @Column(name = "train_type")
    private String trainType;
    @Column(name = "train_weekly_days_schedule")
    private String trainWeeklyDaysSchedule;
    @Column(name = "avg_speed")
    private Integer avgSpeed;
    @Column(name="fare_charges")
    private Integer fareCharges;
    @Column(name = "special_charges")
    private Integer specialCharges;

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public void setNoOfCoach(Integer noOfCoach) {
        this.noOfCoach = noOfCoach;
    }

    public void setTrainStartStation(String trainStartStation) {
        this.trainStartStation = trainStartStation;
    }

    public void setTrainEndStation(String trainEndStation) {
        this.trainEndStation = trainEndStation;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public void setTrainWeeklyDaysSchedule(String trainWeeklyDaysSchedule) {
        this.trainWeeklyDaysSchedule = trainWeeklyDaysSchedule;
    }

    public void setAvgSpeed(Integer avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public void setFareCharges(Integer fareCharges) {
        this.fareCharges = fareCharges;
    }

    public void setSpecialCharges(Integer specialCharges) {
        this.specialCharges = specialCharges;
    }

    @Override
    public String toString() {
        return "SuperFast{" +
                "trainId=" + trainId +
                ", trainName='" + trainName + '\'' +
                ", noOfCoach=" + noOfCoach +
                ", trainStartStation='" + trainStartStation + '\'' +
                ", trainEndStation='" + trainEndStation + '\'' +
                ", trainType='" + trainType + '\'' +
                ", trainWeeklyDaysSchedule='" + trainWeeklyDaysSchedule + '\'' +
                ", avgSpeed=" + avgSpeed +
                ", fareCharges=" + fareCharges +
                ", specialCharges=" + specialCharges +
                '}';
    }
}




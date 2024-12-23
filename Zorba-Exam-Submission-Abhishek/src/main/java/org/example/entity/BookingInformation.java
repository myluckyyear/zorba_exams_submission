package org.example.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_information")
public class BookingInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @Column(name = "booking_date_time")
    private Date bookingDateTime;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passengers passenger;

    @ManyToOne
    @JoinColumn(name = "train_id")
    private Train train;

    // Getters and Setters
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(Date bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}


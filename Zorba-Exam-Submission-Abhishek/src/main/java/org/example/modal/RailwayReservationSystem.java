package org.example.modal;



import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class RailwayReservationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Passengers.class)
                .addAnnotatedClass(Train.class)
                .addAnnotatedClass(BookingInformation.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            // Add a new train
            Train train = new Train();
            train.setTrainName("Super Fast");
            train.setNoOfCoach(10);
            train.setTrainStartStation("StationA");
            train.setTrainEndStation("StationB");
            train.setTrainType("Super Fast");
            train.setTrainWeeklyDaysSchedule("Mon, Wed");
            train.setAvgSpeed(100.5);
            train.setFareCharges(500);
            train.setFrequency("Daily");
            train.setSpecialCharges("50");
            train.setNoOfCities("10");
            train.setTypesOfGoods("Electronics");

            session.beginTransaction();
            session.save(train);
            session.getTransaction().commit();

            // Create new passenger
            Passengers passenger = new SeniorCitizenPassenger();
            passenger.setName("John Doe");
            passenger.setEmail("john@example.com");
            passenger.setMobile("1234567890");
            passenger.setDestination("StationB");
            passenger.setSeatNumber("A1");
            passenger.setCoachType("First Class");

            session.beginTransaction();
            session.save(passenger);
            session.getTransaction().commit();

            // Booking information
            BookingInformation booking = new BookingInformation();
            booking.setBookingDateTime(new java.util.Date());
            booking.setPassenger(passenger);
            booking.setTrain(train);

            session.beginTransaction();
            session.save(booking);
            session.getTransaction().commit();

            // Fetch Physically Handicapped passengers
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<PhysicallyHandicappedPassenger> handicappedPassengers = session.createQuery("from PhysicallyHandicappedPassenger", PhysicallyHandicappedPassenger.class).getResultList();
            for (PhysicallyHandicappedPassenger handicapped : handicappedPassengers) {
                System.out.println(handicapped);
            }
            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}

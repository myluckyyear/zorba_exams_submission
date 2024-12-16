package org.example.execution;



import org.example.util.DatabaseConnectivity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Passenger {

    public void savePassenger(Passenger passenger) {
        Session session = DatabaseConnectivity.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(passenger);
        tx.commit();
        session.close();
    }

    public void fetchPhysicallyHandicapped() {
        Session session = DatabaseConnectivity.getSessionFactory().openSession();
        Query query = session.createQuery("FROM PhysicallyHandicapped");
        List<PhysicallyHandicapped> handicappedPassengers = query.list();
        for (PhysicallyHandicapped p : handicappedPassengers) {
            System.out.println(p);
        }
        session.close();
    }
}
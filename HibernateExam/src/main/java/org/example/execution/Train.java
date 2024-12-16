package org.example.execution;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Train {

    public void saveTrain(Train train) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(train);
        tx.commit();
        session.close();
    }

    public void fetchAllTrains() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Train");
        List<Train> trains = query.list();
        for (Train train : trains) {
            System.out.println(train);
        }
        session.close();
    }
}

package org.example.HibernateUtility;



import org.example.entity.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        //Read the Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(GeneralPassengers.class);
        configuration.addAnnotatedClass(PhysicallyHandicappedPassenger.class);
        configuration.addAnnotatedClass(SeniorCitizenPassenger.class);


        //Create SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("Session Factory Execution Completed, " +
                "Connection established successfully, all the table created...");
        return sessionFactory;
    }
}


package org.example.util;




import org.example.entity.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class DatabaseConnectivity {
    public static SessionFactory getSessionFactory() {
        //Read the Configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(General.class);
        configuration.addAnnotatedClass(PhysicallyHandicapped.class);
        configuration.addAnnotatedClass(SeniorCitizen.class);
        configuration.addAnnotatedClass(GoodsTrain.class);
        configuration.addAnnotatedClass(IntercityExpress.class);
        configuration.addAnnotatedClass(LocalTrain.class);
        configuration.addAnnotatedClass(SuperFast.class);


        //Create SessionFactory Object from configuration
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        System.out.println("Session Factory Execution Completed, " +
                "Connection established successfully, all the table created...");
        return sessionFactory;
    }
}
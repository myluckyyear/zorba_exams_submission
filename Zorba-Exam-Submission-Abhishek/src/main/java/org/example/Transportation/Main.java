package org.example.Transportation;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // Load Spring Configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Get Driver Bean
        Driver driver = (Driver) context.getBean("driver");
        System.out.println("Driver Details: " + driver);

        // Get Vehicle Bean
        Vehicle vehicle = (Vehicle) context.getBean("vehicle");
        System.out.println("Vehicle Details: " + vehicle);

        // Get Destination Bean
        Destination destination = (Destination) context.getBean("destination");
        System.out.println("Destination Details: " + destination);

        // Get Address Bean
        Address address = (Address) context.getBean("address");
        System.out.println("Address Details: " + address);

        // Verify Relationships
        System.out.println("\nRelationships:");
        System.out.println("Driver's Vehicle: " + driver.getVehicle());
        System.out.println("Driver's Destination: " + driver.getDestination());
        System.out.println("Destination's Address: " + destination.getAddress());
    }
}
package org.example.execution;



import org.example.entity.General;
import org.example.entity.PhysicallyHandicapped;
import org.example.entity.SeniorCitizen;
import org.example.util.DatabaseConnectivity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class RailwayReservationSystems {
    public static void main(String[] args) {
        SessionFactory sessionFactory = DatabaseConnectivity.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        Scanner scanner = new Scanner(System.in);

        try {
            tx = session.beginTransaction();

            // Prepare and persist the passenger data
            General general = prepareGeneral(scanner);
            session.persist(general);

            PhysicallyHandicapped physicallyHandicapped = preparePhysicallyHandicapped(scanner);
            session.persist(physicallyHandicapped);

            SeniorCitizen seniorCitizen = prepareSeniorCitizen(scanner);
            session.persist(seniorCitizen);

            tx.commit();  // Commit transaction
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();  // Rollback transaction if error occurs
            }
            System.err.println("Error: " + e.getMessage());
        } finally {
            session.close();  // Close session in the end
        }
    }

    private static General prepareGeneral(Scanner scanner) {
        General general = new General();
        System.out.println("Enter passenger name: ");
        general.setName(scanner.nextLine());

        System.out.println("Enter passenger email: ");
        general.setEmail(scanner.nextLine());

        System.out.println("Enter passenger mobile: ");
        general.setMobile(scanner.nextInt());

        System.out.println("Enter passenger destination: ");
        general.setDestination(scanner.nextLine());

        System.out.println("Enter passenger seat number: ");
        general.setSeatNumber(scanner.nextLine());

        System.out.println("Enter passenger coach type: ");
        general.setCoachType(scanner.nextLine());

        return general;
    }

    private static PhysicallyHandicapped preparePhysicallyHandicapped(Scanner scanner) {
        PhysicallyHandicapped handicapped = new PhysicallyHandicapped();
        System.out.println("Enter passenger name: ");
        handicapped.setName(scanner.nextLine());

        System.out.println("Enter passenger email: ");
        handicapped.setEmail(scanner.nextLine());

        System.out.println("Enter passenger mobile: ");
        handicapped.setMobile(scanner.nextInt());

        System.out.println("Enter passenger destination: ");
        handicapped.setDestination(scanner.nextLine());

        System.out.println("Enter passenger seat number: ");
        handicapped.setSeatNumber(scanner.nextLine());

        System.out.println("Enter passenger proof of disability: ");
        handicapped.setProofOfDisability(scanner.nextLine());

        return handicapped;
    }

    private static SeniorCitizen prepareSeniorCitizen(Scanner scanner) {
        SeniorCitizen seniorCitizen = new SeniorCitizen();
        System.out.println("Enter passenger name: ");
        seniorCitizen.setName(scanner.nextLine());

        System.out.println("Enter passenger email: ");
        seniorCitizen.setEmail(scanner.nextLine());

        System.out.println("Enter passenger mobile: ");
        seniorCitizen.setMobile(scanner.nextInt());

        System.out.println("Enter passenger destination: ");
        seniorCitizen.setDestination(scanner.nextLine());

        System.out.println("Enter passenger seat number: ");
        seniorCitizen.setSeatNumber(scanner.nextLine());

        System.out.println("Enter passenger discount: ");
        seniorCitizen.setDiscount(scanner.nextInt());

        return seniorCitizen;
    }
}

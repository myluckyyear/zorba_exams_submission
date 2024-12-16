package org.example.execution;



import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Train
        System.out.print("Enter train name: ");
        String name = sc.nextLine();
        System.out.print("Enter number of coaches: ");
        int coaches = sc.nextInt();
        // Take other inputs similarly...


        Train train = new Train();
        train.saveTrain(train);

        // Input for Passengers
        System.out.print("Enter passenger name: ");
        String passengerName = sc.nextLine();
        // Take other inputs similarly...

        Passenger passenger = new Passenger();
        passenger.savePassenger(passenger);

        // Fetch Physically Handicapped Passengers
        passenger.fetchPhysicallyHandicapped();
    }
}
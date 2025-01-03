package org.example.RentOfOneBHKFlat;

public class RentOfThreeBHKFlat extends RentOfOneFlat {
    private String balcony = "yes";

    public int calculateRentOfFlat(int noOfPerson) {
        return 600 * noOfPerson;
    }

    public String getBalcony() {
        return balcony;
    }
}
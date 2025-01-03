package org.example.RentOfOneBHKFlat;

public class RentOfTwoBHKFlat extends RentOfOneFlat {
    private String balcony = "Yes";

    public int CalculateRentOfFlat(int noofperson) {
        return 400 * noofperson;
    }

    public String getBalcony() {
        return balcony;
    }
}


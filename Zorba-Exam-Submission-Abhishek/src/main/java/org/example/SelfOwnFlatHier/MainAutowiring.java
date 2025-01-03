package org.example.SelfOwnFlatHier;

import org.example.RentOfOneBHKFlat.RentOfOneFlat;
import org.example.RentOfOneBHKFlat.RentOfThreeBHKFlat;
import org.example.RentOfOneBHKFlat.RentOfTwoBHKFlat;

import java.text.Annotation;

public class MainAutowiring {
    private RentOfOneFlat.RentOfOneBHKFlat rentOfOneBHKFlat;
    private RentOfTwoBHKFlat rentOfTwoBHKFlat;
    private RentOfThreeBHKFlat rentOfThreeBHKFlat;
    private SelfOwnedOneBKHFlat selfOwnedOneBHKFlat;
    private SelfOwnedTwoBHKFlat selfOwnedTwoBHKFlat;
    private SelfOwnedThreeBHKFlat selfOwnedThreeBHKFlat;

    public static <AutowiringContext> void main(String[] args) {
        AutowiringContext context = new Annotation(MainAutowiring.class);

        MainAutowiring app = context.getBean(MainAutowiring.class);
        System.out.println("Rent for One BHK Flat");
        System.out.println("Rent for Two BHK Flat");
        System.out.println("Rent for Three BHK Flat");
        System.out.println("Final price for self-Owned One BHK Flat");
        System.out.println("Final price for self-Owned Two BHK Flat");
        System.out.println("Final price for self-Owned Three BHK Flat");

    }
}

{
}

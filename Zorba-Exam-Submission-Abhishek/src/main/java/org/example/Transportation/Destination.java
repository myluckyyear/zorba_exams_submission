package org.example.Transportation;



public class Destination {
    private int destinationId;
    private String name;
    private Address address;

    public Destination(int destinationId, String name, Address address) {
        this.destinationId = destinationId;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Destination [destinationId=" + destinationId + ", name=" + name + ", address=" + address + "]";
    }
}
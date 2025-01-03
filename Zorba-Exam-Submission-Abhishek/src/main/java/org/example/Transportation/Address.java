package org.example.Transportation;

public class Address {
    private int addressId;
    private String area;
    private int pincode;

    public Address(int addressId, String area, int pincode) {
        this.addressId = addressId;
        this.area = area;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", area=" + area + ", pincode=" + pincode + "]";
    }
}
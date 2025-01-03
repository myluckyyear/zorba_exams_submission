package org.example.SelfOwnFlatHier;

public class SelfOwnedTwoBHKFlat extends SelfOwnedOneBKHFlat {
    public float calculatePlot(float lenght, float breadth, float height) {
        return lenght * breadth * height;
    }
    public float finalPriceOfFlat(float lenght, float breadth, float height) {
        return 30000 * calculatePlot(lenght, breadth, height);
    }
}

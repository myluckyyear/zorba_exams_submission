package org.example.SelfOwnFlatHier;

public class SelfOwnedOneBKHFlat {
    public static class SelfOwnedOneFlat extends SelfOwnedOneBKHFlat {
      public float calculatePlot(float length, float breadth, float height){
          return length * breadth * height;
      }
      public float finalPriceOfFlat(float lenght, float breadth, float height) {
          return 10000 * calculatePlot(lenght, breadth, height);
      }
  }
}

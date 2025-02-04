package com.otp.taxiapi.trip;

public class Trip {
    private int numOfPassengers;

    private float distance;

    public Trip(float distance, int numOfPassengers) {
        this.distance = distance;
        this.numOfPassengers = numOfPassengers;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}

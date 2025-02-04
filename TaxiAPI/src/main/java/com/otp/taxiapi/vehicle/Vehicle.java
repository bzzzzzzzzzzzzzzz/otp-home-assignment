package com.otp.taxiapi.vehicle;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    private int range;

    private String fuel;

    public Vehicle() {

    }

    public Vehicle(int range, int passengerCapacity, String fuel) {
        this.range = range;
        this.passengerCapacity = passengerCapacity;
        this.fuel = fuel;
    }

    public Vehicle(int id, int range, String fuel, int passengerCapacity) {
        this.id = id;
        this.range = range;
        this.fuel = fuel;
        this.passengerCapacity = passengerCapacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}

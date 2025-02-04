package com.otp.taxiapi.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Map<Integer, Float> getPossibleVehicles(int numOfPassengers, float distance) {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        Map<Integer, Float> possibleVehicles = new HashMap<>();
        for (Vehicle vehicle : vehicles) {
            if(vehicle.getPassengerCapacity() >= numOfPassengers && vehicle.getRange() >= distance) {
                float profit = getProfit(vehicle, numOfPassengers, distance);
                possibleVehicles.put(vehicle.getId(), profit);
            }
        }
        return possibleVehicles;
    }

    // Profit calculation for a vehicle
    private float getProfit(Vehicle vehicle, int numOfPassengers, float distance) {
        float minutesTravelled = 0;
        if (distance < 50.0f) {
            minutesTravelled = 2 * distance;
        } else {
            minutesTravelled = 2 * 50 + (distance - 50);
        }
        int numOfHalfHoursStarted = (int) (minutesTravelled / 30) + (minutesTravelled % 30 == 0 ? 0 : 1);

        float travelFee = numOfPassengers * 2 * distance + 2 * numOfHalfHoursStarted;

        float refueling = 0;
        if (Objects.equals(vehicle.getFuel(), "gasoline")) {
            refueling = 2 * distance;
        } else if (Objects.equals(vehicle.getFuel(), "mild hybrid")) {
            if (distance < 50.0f) {
                refueling = distance;
            } else {
                refueling = distance + 2 * (distance - 50);
            }
        } else if (Objects.equals(vehicle.getFuel(), "pure electric")) {
            refueling = distance;
        }

        return travelFee - refueling;
    }
}

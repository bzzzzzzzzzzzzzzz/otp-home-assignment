package com.otp.taxiapi.vehicle;

import com.otp.taxiapi.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleService.getVehicles();
    }

    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
        vehicle.setId(null);
        Vehicle newVehicle = vehicleService.addVehicle(vehicle);
        return new ResponseEntity<>(newVehicle, HttpStatus.CREATED);
    }

    @GetMapping("/trip")
    public Map<Integer, Float> getPossibleVehicles(@RequestBody Trip trip) {
        return vehicleService.getPossibleVehicles(trip.getNumOfPassengers(), trip.getDistance());
    }
}

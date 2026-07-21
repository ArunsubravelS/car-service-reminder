package com.carservice.vehicle.service;

import com.carservice.vehicle.dto.VehicleRequest;
import com.carservice.vehicle.dto.VehicleResponse;
import com.carservice.vehicle.entity.Vehicle;
import com.carservice.vehicle.repository.VehicleRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public VehicleResponse addVehicle(Long userId, VehicleRequest request) {

        Vehicle vehicle = new Vehicle();

        vehicle.setUserId(userId);
        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setRegistrationNumber(request.getRegistrationNumber());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setCurrentKm(request.getCurrentKm());
        vehicle.setServiceInterval(request.getServiceInterval());
        vehicle.setLastServiceDate(request.getLastServiceDate());

        Vehicle saved = repository.save(vehicle);

        return mapToResponse(saved);

    }

    public List<VehicleResponse> getVehicles(Long userId) {

        List<Vehicle> vehicles = repository.findByUserId(userId);

        List<VehicleResponse> response = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            response.add(mapToResponse(vehicle));
        }

        return response;

    }

    public VehicleResponse getVehicle(Long id) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Vehicle not found"));

        return mapToResponse(vehicle);

    }

    public VehicleResponse updateVehicle(Long id,
                                         VehicleRequest request) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Vehicle not found"));

        vehicle.setBrand(request.getBrand());
        vehicle.setModel(request.getModel());
        vehicle.setRegistrationNumber(request.getRegistrationNumber());
        vehicle.setFuelType(request.getFuelType());
        vehicle.setCurrentKm(request.getCurrentKm());
        vehicle.setServiceInterval(request.getServiceInterval());
        vehicle.setLastServiceDate(request.getLastServiceDate());

        Vehicle updated = repository.save(vehicle);

        return mapToResponse(updated);

    }

    public String deleteVehicle(Long id) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Vehicle not found"));

        repository.delete(vehicle);

        return "Vehicle deleted successfully.";

    }

    private VehicleResponse mapToResponse(Vehicle vehicle) {

        VehicleResponse response = new VehicleResponse();

        response.setId(vehicle.getId());
        response.setBrand(vehicle.getBrand());
        response.setModel(vehicle.getModel());
        response.setRegistrationNumber(vehicle.getRegistrationNumber());
        response.setFuelType(vehicle.getFuelType());
        response.setCurrentKm(vehicle.getCurrentKm());
        response.setServiceInterval(vehicle.getServiceInterval());
        response.setLastServiceDate(vehicle.getLastServiceDate());

        return response;

    }

}
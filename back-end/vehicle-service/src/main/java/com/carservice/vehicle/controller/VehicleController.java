package com.carservice.vehicle.controller;

import com.carservice.vehicle.dto.VehicleRequest;
import com.carservice.vehicle.dto.VehicleResponse;
import com.carservice.vehicle.service.VehicleService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public VehicleResponse addVehicle(
            @RequestParam Long userId,
            @RequestBody VehicleRequest request) {

        return service.addVehicle(userId, request);

    }

    @GetMapping
    public List<VehicleResponse> getVehicles(
            @RequestParam Long userId) {

        return service.getVehicles(userId);

    }

    @GetMapping("/{id}")
    public VehicleResponse getVehicle(
            @PathVariable Long id) {

        return service.getVehicle(id);

    }

    @PutMapping("/{id}")
    public VehicleResponse updateVehicle(
            @PathVariable Long id,
            @RequestBody VehicleRequest request) {

        return service.updateVehicle(id, request);

    }

    @DeleteMapping("/{id}")
    public String deleteVehicle(
            @PathVariable Long id) {

        return service.deleteVehicle(id);

    }

}
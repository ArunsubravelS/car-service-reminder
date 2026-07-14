package com.carservice.vehicle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	
    @GetMapping("/health")
    public String health() {
        return "Ve Service Running...";
    }

}

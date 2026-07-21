package com.carservice.vehicle.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String brand;

    private String model;

    private String registrationNumber;

    private String fuelType;

    private Integer currentKm;

    private Integer serviceInterval;

    private LocalDate lastServiceDate;

    public Vehicle() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getCurrentKm() {
		return currentKm;
	}

	public void setCurrentKm(Integer currentKm) {
		this.currentKm = currentKm;
	}

	public Integer getServiceInterval() {
		return serviceInterval;
	}

	public void setServiceInterval(Integer serviceInterval) {
		this.serviceInterval = serviceInterval;
	}

	public LocalDate getLastServiceDate() {
		return lastServiceDate;
	}

	public void setLastServiceDate(LocalDate lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

    
}
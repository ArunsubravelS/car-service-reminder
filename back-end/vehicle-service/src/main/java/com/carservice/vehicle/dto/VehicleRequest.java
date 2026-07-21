package com.carservice.vehicle.dto;

import java.time.LocalDate;

public class VehicleRequest {

    private String brand;
    private String model;
    private String registrationNumber;
    private String fuelType;
    private Integer currentKm;
    private Integer serviceInterval;
    private LocalDate lastServiceDate;

    public VehicleRequest() {}

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
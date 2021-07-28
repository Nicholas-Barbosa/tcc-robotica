package com.puc.tcc.dto;

import java.time.LocalDate;

import com.puc.tcc.domain.Car;

public class CarDto {

	private int id;
	private String name;
	private LocalDate createdAt;

	public static CarDto ofCar(Car car) {
		return new CarDto(car.getId(), car.getName(), car.getCreatedAt());
	}

	public CarDto(int id, String name, LocalDate createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

}

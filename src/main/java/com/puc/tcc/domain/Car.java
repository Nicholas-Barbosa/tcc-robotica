package com.puc.tcc.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Car extends BaseEntity {

	@Column(unique = true)
	private String name;
	private LocalDate createdAt;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String name, LocalDate createdAt) {
		super();
		this.name = name;
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

}

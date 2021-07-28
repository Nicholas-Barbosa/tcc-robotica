package com.puc.tcc.dto;

import java.time.LocalDateTime;

import com.puc.tcc.domain.AquariumMetric;

public class AquariumMetricDTO {

	private LocalDateTime createdAt;
	private float ph;
	private float temperature;

	public AquariumMetricDTO() {
		// TODO Auto-generated constructor stub
	}

	public AquariumMetricDTO(AquariumMetric aq) {
		super();
		this.createdAt = aq.getCreatedAt();
		this.ph = aq.getPh();
		this.temperature = aq.getTemperature();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public float getPh() {
		return ph;
	}

	public void setPh(float ph) {
		this.ph = ph;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

}

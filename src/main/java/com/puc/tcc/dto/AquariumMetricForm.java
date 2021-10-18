package com.puc.tcc.dto;

import com.puc.tcc.domain.Aquarium;
import com.puc.tcc.domain.AquariumMetric;

public class AquariumMetricForm {

	private float temperature;
	private float ph;

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getPh() {
		return ph;
	}

	public void setPh(float ph) {
		this.ph = ph;
	}

	public AquariumMetric toEntity() {
		Aquarium aquarium = new Aquarium(1, null);
		AquariumMetric metric = new AquariumMetric(temperature, ph);
		aquarium.addMetric(metric);
		return metric;
	}

	@Override
	public String toString() {
		return "AquariumMetricForm [temperature=" + temperature + ", ph=" + ph + "]";
	}

}

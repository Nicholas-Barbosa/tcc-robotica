package com.puc.tcc.dto;

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

	@Override
	public String toString() {
		return "AquariumMetricForm [temperature=" + temperature + ", ph=" + ph + "]";
	}

}

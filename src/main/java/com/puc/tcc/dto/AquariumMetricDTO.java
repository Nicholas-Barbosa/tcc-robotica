package com.puc.tcc.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.puc.tcc.domain.AquariumMetric;

public class AquariumMetricDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4519389382430627047L;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + Float.floatToIntBits(ph);
		result = prime * result + Float.floatToIntBits(temperature);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AquariumMetricDTO other = (AquariumMetricDTO) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (Float.floatToIntBits(ph) != Float.floatToIntBits(other.ph))
			return false;
		if (Float.floatToIntBits(temperature) != Float.floatToIntBits(other.temperature))
			return false;
		return true;
	}

	
}

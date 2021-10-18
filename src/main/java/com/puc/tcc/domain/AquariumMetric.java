package com.puc.tcc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "aquarium_metric")
@Entity
public class AquariumMetric extends BaseEntity implements Comparable<AquariumMetric> {

	private LocalDateTime createdAt;
	private float temperature;
	private float ph;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aqurium_id")
	private Aquarium aquarium;

	public AquariumMetric() {
		this(0, 0);
	}

	public AquariumMetric(float temperature, float ph) {
		super(null);
		this.createdAt = LocalDateTime.now();
		this.temperature = temperature;
		this.ph = ph;
	}

	public AquariumMetric(Integer id, LocalDateTime createdAt, float temperature, float ph) {
		super(id);
		this.createdAt = createdAt;
		this.temperature = temperature;
		this.ph = ph;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public float getTemperature() {
		return temperature;
	}

	public float getPh() {
		return ph;
	}

	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}

	@Override
	public int compareTo(AquariumMetric o) {
		// TODO Auto-generated method stub
		return o.createdAt.compareTo(createdAt);
	}

}
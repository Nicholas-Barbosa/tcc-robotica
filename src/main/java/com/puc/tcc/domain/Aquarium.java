package com.puc.tcc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aquarium extends BaseEntity {

	private String name;

	@OneToMany(mappedBy = "aquarium")
	private Set<Fish> fish;

	@OneToMany(mappedBy = "aquarium")
	private Set<AquariumMetric> metrics;

	public Aquarium() {
		this(null, null, null, null);
	}

	public Aquarium(Integer id, String name, Set<Fish> fish, Set<AquariumMetric> metrics) {
		super(id);
		this.name = name;
		this.fish = fish;
		this.metrics = metrics;
	}

	public Aquarium(Integer id, String name) {
		this(id, name, new HashSet<>(), new HashSet<>());
	}

	public String getName() {
		return name;
	}

	public Set<Fish> getFish() {
		return fish;
	}

	public Set<AquariumMetric> getMetrics() {
		return new HashSet<>(metrics);
	}

	public void addMetric(AquariumMetric metric) {
		metric.setAquarium(this);
		metrics.add(metric);
	}

}

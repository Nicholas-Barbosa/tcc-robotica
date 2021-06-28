package com.puc.tcc.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Aquarium extends BaseEntity {

	private final String name;
	private final Float temperature;
	private final Float ph;
	private final User owner;
	@OneToMany(mappedBy = "specie")
	private final Set<Fish> fish;

	public Aquarium(String name, Float temperature, Float ph, User owner, Set<Fish> fish) {
		super(null);
		this.name = name;
		this.temperature = temperature;
		this.ph = ph;
		this.owner = owner;
		this.fish = new HashSet<>(fish);
	}

	public Aquarium(Integer id, String name, Float temperature, Float ph, User owner, Set<Fish> fish) {
		super(id);
		this.name = name;
		this.temperature = temperature;
		this.ph = ph;
		this.owner = owner;
		this.fish = fish;
	}

	public String getName() {
		return name;
	}

	public Float getTemperature() {
		return temperature;
	}

	public Float getPh() {
		return ph;
	}

	public User getOwner() {
		return owner;
	}

	public Set<Fish> getFish() {
		return new HashSet<>(fish);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Aquarium other = (Aquarium) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

package com.puc.tcc.domain;

import javax.persistence.Entity;

@Entity
public class FishSpecie extends BaseEntity {

	private String specie;
	private Float idealTemperature;
	private Float idealWaterTemperature;

	public FishSpecie() {
		this(null, null, null);
	}

	public FishSpecie(String specie, Float idealTemperature, Float idealWaterTemperature) {
		super(null);
		this.specie = specie;
		this.idealTemperature = idealTemperature;
		this.idealWaterTemperature = idealWaterTemperature;
	}

	public FishSpecie(Integer id, String specie, Float idealTemperature, Float idealWaterTemperature) {
		super(id);
		this.specie = specie;
		this.idealTemperature = idealTemperature;
		this.idealWaterTemperature = idealWaterTemperature;
	}

	public String getSpecie() {
		return specie;
	}

	public Float getIdealTemperature() {
		return idealTemperature;
	}

	public Float getIdealWaterTemperature() {
		return idealWaterTemperature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((specie == null) ? 0 : specie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FishSpecie other = (FishSpecie) obj;
		if (specie == null) {
			if (other.specie != null)
				return false;
		} else if (!specie.equals(other.specie))
			return false;
		return true;
	}

}

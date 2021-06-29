package com.puc.tcc.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Fish extends BaseEntity {

	private final String name;
	@ManyToOne
	private final FishSpecie specie;

	public Fish() {
		this(null, null);
	}

	public Fish(String name, FishSpecie specie) {
		super(null);
		this.name = name;
		this.specie = specie;
	}

	public Fish(Integer id, String name, FishSpecie specie) {
		super(id);
		this.name = name;
		this.specie = specie;
	}

	public String getName() {
		return name;
	}

	public FishSpecie getSpecie() {
		return specie;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((specie == null) ? 0 : specie.hashCode());
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
		Fish other = (Fish) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (specie == null) {
			if (other.specie != null)
				return false;
		} else if (!specie.equals(other.specie))
			return false;
		return true;
	}

}

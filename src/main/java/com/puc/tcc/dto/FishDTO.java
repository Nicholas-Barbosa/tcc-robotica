package com.puc.tcc.dto;

import com.puc.tcc.domain.Fish;
import com.puc.tcc.domain.FishSpecie;

public class FishDTO {

	private String name;
	private FishSpecieDTO specie;

	public static FishDTO of(Fish fishDomain) {
		FishSpecieDTO specie = FishSpecieDTO.of(fishDomain.getSpecie());
		FishDTO fish = new FishDTO(fishDomain.getName(), specie);
		return fish;
	}

	public FishDTO(String name, FishSpecieDTO specie) {
		super();
		this.name = name;
		this.specie = specie;
	}

	public String getName() {
		return name;
	}

	public FishSpecieDTO getSpecie() {
		return specie;
	}

	public static class FishSpecieDTO {
		private float idealTemperature;
		private float idealWaterTemperature;

		public static FishSpecieDTO of(FishSpecie specie) {
			return new FishSpecieDTO(specie.getIdealTemperature(), specie.getIdealWaterTemperature());
		}

		public FishSpecieDTO(float idealTemperature, float idealWaterTemperature) {
			super();
			this.idealTemperature = idealTemperature;
			this.idealWaterTemperature = idealWaterTemperature;
		}

		public float getIdealTemperature() {
			return idealTemperature;
		}

		public float getIdealWaterTemperature() {
			return idealWaterTemperature;
		}

	}
}

package com.puc.tcc.dto;

import javax.json.bind.annotation.JsonbProperty;

public class FishDTO {

	@JsonbProperty("name")
	private String name;

	private String specie;

	public FishDTO(String name, String specie) {
		super();
		this.name = name;
		this.specie = specie;
	}

	public String getName() {
		return name;
	}

	public String getSpecie() {
		return specie;
	}

}

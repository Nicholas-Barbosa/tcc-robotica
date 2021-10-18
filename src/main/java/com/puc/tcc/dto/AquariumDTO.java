package com.puc.tcc.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.puc.tcc.domain.Aquarium;
import com.puc.tcc.domain.Fish;

public class AquariumDTO {

	private String name;
	private List<FishDTO> fish;

	public static AquariumDTO of(Aquarium aq) {
		return new AquariumDTO(aq.getName(), aq.getFish());
	}

	public AquariumDTO(String name, Set<Fish> fish) {
		super();
		this.name = name;
		this.fish = fish.stream().map(FishDTO::of).collect(Collectors.toList());
	}

	public String getName() {
		return name;
	}

	public List<FishDTO> getFish() {
		return fish;
	}

}

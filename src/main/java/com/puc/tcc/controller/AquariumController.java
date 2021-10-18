package com.puc.tcc.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.puc.tcc.dto.AquariumDTO;
import com.puc.tcc.service.AquariumService;

@ViewScoped
@Named
public class AquariumController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6115936811335399558L;

	private AquariumDTO aquarium;

	@Inject
	private AquariumService aquariumService;

	public void findAquarium() {
		aquariumService.findByFixedId().ifPresent(aquarium -> {
			this.aquarium = aquarium;
		});
	}
	
	public AquariumDTO getAquarium() {
		return aquarium;
	}
}

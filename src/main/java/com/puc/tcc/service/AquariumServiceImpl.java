package com.puc.tcc.service;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.puc.tcc.domain.Aquarium;
import com.puc.tcc.dto.AquariumDTO;
import com.puc.tcc.repository.AquariumRepository;

@ApplicationScoped
public class AquariumServiceImpl implements AquariumService {

	@Inject
	private AquariumRepository repository;

	@Override
	public Optional<AquariumDTO> findByFixedId() {
		Optional<Aquarium> maybe = repository.findById(1);
		if (maybe.isPresent())
			return Optional.of(AquariumDTO.of(maybe.get()));
		return Optional.empty();
	}

}

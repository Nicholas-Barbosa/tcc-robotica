package com.puc.tcc.service;

import java.util.Optional;

import com.puc.tcc.dto.AquariumDTO;

public interface AquariumService {

	Optional<AquariumDTO> findByFixedId();
}

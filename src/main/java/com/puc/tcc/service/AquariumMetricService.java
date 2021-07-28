package com.puc.tcc.service;

import java.util.Optional;
import java.util.Set;

import com.puc.tcc.domain.AquariumMetric;
import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.dto.AquariumMetricForm;

public interface AquariumMetricService {

	AquariumMetricDTO findLastMetric();

	Set<AquariumMetricDTO> findAll();

	AquariumMetric save(AquariumMetricForm aquariumMetric);

	Optional<AquariumMetricDTO> findById(Integer id);
}

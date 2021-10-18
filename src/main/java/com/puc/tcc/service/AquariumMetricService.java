package com.puc.tcc.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.dto.AquariumMetricForm;

public interface AquariumMetricService {

	AquariumMetricDTO findLastMetric();

	List<AquariumMetricDTO> findAllOrderByLastMetric();
	
	Set<AquariumMetricDTO> findAll();

	void save(AquariumMetricForm aquariumMetric);

	Optional<AquariumMetricDTO> findById(Integer id);
}

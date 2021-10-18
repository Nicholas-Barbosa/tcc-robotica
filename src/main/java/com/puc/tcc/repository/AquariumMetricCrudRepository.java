package com.puc.tcc.repository;

import java.util.List;

import com.puc.tcc.domain.AquariumMetric;

public interface AquariumMetricCrudRepository extends CrudRepository<AquariumMetric, Integer> {

	AquariumMetric findLastMetric();

	List<AquariumMetric>findOrderByLastMetrics();
}

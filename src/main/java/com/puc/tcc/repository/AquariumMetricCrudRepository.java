package com.puc.tcc.repository;

import com.puc.tcc.domain.AquariumMetric;

public interface AquariumMetricCrudRepository extends CrudRepository<AquariumMetric, Integer> {

	AquariumMetric findLastMetric();

}

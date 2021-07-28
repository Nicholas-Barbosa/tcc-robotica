package com.puc.tcc.service;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.puc.tcc.cdi.qualifier.Memory;
import com.puc.tcc.domain.AquariumMetric;
import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.dto.AquariumMetricForm;
import com.puc.tcc.repository.AquariumMetricCrudRepository;

@ApplicationScoped
public class AquariumMetricServiceImpl implements AquariumMetricService {

	private final AquariumMetricCrudRepository repository;

	@Inject
	public AquariumMetricServiceImpl(@Memory AquariumMetricCrudRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public AquariumMetricDTO findLastMetric() {
		// TODO Auto-generated method stub
		return new AquariumMetricDTO(repository.findLastMetric());
	}

	@Override
	public Set<AquariumMetricDTO> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll().parallelStream().map(AquariumMetricDTO::new).collect(CopyOnWriteArraySet::new,
				Set::add, Set::addAll);
	}

	@Override
	public AquariumMetric save(AquariumMetricForm aquariumMetric) {
		// TODO Auto-generated method stub
		return repository.save(new AquariumMetric(aquariumMetric.getTemperature(), aquariumMetric.getPh()));
	}

	@Override
	public Optional<AquariumMetricDTO> findById(Integer id) {
		return repository.findById(id).map(AquariumMetricDTO::new);
	}

}

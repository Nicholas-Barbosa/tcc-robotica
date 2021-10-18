package com.puc.tcc.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.puc.tcc.cdi.qualifier.Jpa;
import com.puc.tcc.dto.AquariumMetricDTO;
import com.puc.tcc.dto.AquariumMetricForm;
import com.puc.tcc.repository.AquariumMetricCrudRepository;

@ApplicationScoped
public class AquariumMetricServiceImpl implements AquariumMetricService {

	private final AquariumMetricCrudRepository repository;

	@Inject
	public AquariumMetricServiceImpl(@Jpa AquariumMetricCrudRepository repository) {
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
	public void save(AquariumMetricForm aquariumMetric) {
		// TODO Auto-generated method stub
		repository.save(aquariumMetric.toEntity());
	}

	@Override
	public Optional<AquariumMetricDTO> findById(Integer id) {
		return repository.findById(id).map(AquariumMetricDTO::new);
	}

	@Override
	public List<AquariumMetricDTO> findAllOrderByLastMetric() {
		// TODO Auto-generated method stub
		return repository.findOrderByLastMetrics().stream().map(AquariumMetricDTO::new).collect(Collectors.toList());
	}

}

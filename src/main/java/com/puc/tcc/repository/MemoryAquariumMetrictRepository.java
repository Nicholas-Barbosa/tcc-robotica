package com.puc.tcc.repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.puc.tcc.cdi.qualifier.Memory;
import com.puc.tcc.domain.Aquarium;
import com.puc.tcc.domain.AquariumMetric;

@Memory
@ApplicationScoped
public class MemoryAquariumMetrictRepository implements AquariumMetricCrudRepository {

	private final Set<AquariumMetric> metrics = new ConcurrentSkipListSet<>();

	@PostConstruct
	public void init() {
		this.initMetrics();
	}

	@Override
	public Set<AquariumMetric> findAll() {
		// TODO Auto-generated method stub
		return new HashSet<>(metrics);
	}

	@Override
	public AquariumMetric findLastMetric() {
		// TODO Auto-generated method stub
		return (AquariumMetric) metrics.toArray()[0];
	}

	private void initMetrics() {

		Aquarium aq1 = new Aquarium(1, "Aquarium 1");
		AquariumMetric metric1 = new AquariumMetric(1, LocalDateTime.of(2021, 7, 26, 14, 20), 20.2f, 6f);
		AquariumMetric metric2 = new AquariumMetric(2, LocalDateTime.of(2021, 7, 26, 13, 20), 22.2f, 2.3f);
		AquariumMetric metric3 = new AquariumMetric(3, LocalDateTime.of(2021, 7, 26, 13, 10), 10.2f, 11.3f);
		aq1.addMetric(metric1);
		aq1.addMetric(metric2);
		aq1.addMetric(metric3);
		metrics.add(metric3);
		metrics.add(metric2);
		metrics.add(metric1);

	}

	@Override
	public void save(AquariumMetric aquarium) {
		int lastId = metrics.parallelStream().collect(Collectors.maxBy((a, b) -> a.getId().compareTo(b.getId()))).get()
				.getId() + 1;
		aquarium.setId(lastId);
		metrics.add(aquarium);
	}

	@Override
	public Optional<AquariumMetric> findById(Integer id) {
		return metrics.parallelStream().filter(a->a.getId().equals(id)).findAny();
	}

	@Override
	public List<AquariumMetric> findOrderByLastMetrics() {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.puc.tcc.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.puc.tcc.cdi.qualifier.Jpa;
import com.puc.tcc.domain.AquariumMetric;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Jpa
public class JpaAquariumMetricCrudRepository implements AquariumMetricCrudRepository {

	@PersistenceContext(name = "persistenceUnit")
	private EntityManager en;

	@Override
	public Set<AquariumMetric> findAll() {
		// TODO Auto-generated method stub
		return en.createQuery("from AquariumMetric aq", AquariumMetric.class).getResultList().parallelStream()
				.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
	}

	@Override
	public void save(AquariumMetric t) {
		en.persist(t);
	}

	@Override
	public Optional<AquariumMetric> findById(Integer id) {
		return Optional.of(en.find(AquariumMetric.class, id));
	}

	@Override
	public AquariumMetric findLastMetric() {
		// TODO Auto-generated method stub
		return en.createQuery("FROM AquariumMetric aq ORDER BY aq.createdAt DESC", AquariumMetric.class)
				.setMaxResults(1).getSingleResult();
	}

	@Override
	public List<AquariumMetric> findOrderByLastMetrics() {
		// TODO Auto-generated method stub
		return en.createQuery("FROM AquariumMetric aq ORDER BY aq.createdAt DESC", AquariumMetric.class)
				.getResultList();
	}

}

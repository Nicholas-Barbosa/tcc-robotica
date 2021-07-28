package com.puc.tcc.repository;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.puc.tcc.domain.Fish;

@Stateless
public class FishRepositoryImpl implements FishRepository {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public Set<Fish> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM Fish", Fish.class).getResultStream().parallel()
				.collect(ConcurrentSkipListSet::new, Set::add, Set::addAll);
	}

	@Override
	public Fish save(Fish t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Fish> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

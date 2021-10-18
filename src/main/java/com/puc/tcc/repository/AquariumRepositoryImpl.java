package com.puc.tcc.repository;

import java.util.Optional;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.puc.tcc.domain.Aquarium;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AquariumRepositoryImpl implements AquariumRepository {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public Set<Aquarium> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Aquarium t) {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Aquarium> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(
				entityManager.createQuery("FROM Aquarium a join fetch a.fish f join fetch f.specie s WHERE a.id =:id",
						Aquarium.class).setParameter("id", id).getSingleResult());
	}

}

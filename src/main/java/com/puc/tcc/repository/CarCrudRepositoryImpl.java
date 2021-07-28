package com.puc.tcc.repository;

import java.util.Optional;
import java.util.Set;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.puc.tcc.domain.Car;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CarCrudRepositoryImpl implements CarCrudRepository {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public Set<Car> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car save(Car t) {
		entityManager.persist(t);
		return t;
	}

	@Override
	public Optional<Car> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(entityManager.find(Car.class, id));
	}

}

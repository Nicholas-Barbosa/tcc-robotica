package com.puc.tcc.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.puc.tcc.domain.Fish;
@Stateless
public class FishRepositoryImpl implements FishRepository {

	@PersistenceContext(unitName = "persitenceUnit")
	private EntityManager entityManager;

	@Override
	public List<Fish> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM Fish", Fish.class).getResultList();
	}

}

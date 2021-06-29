package com.puc.tcc.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.puc.tcc.domain.Fish;

@Stateless
public class FishServiceImpl implements FishService {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public List<Fish> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("FROM Fish f", Fish.class).getResultList();
	}

}

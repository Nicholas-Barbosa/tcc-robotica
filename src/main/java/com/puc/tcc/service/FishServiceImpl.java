package com.puc.tcc.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.puc.tcc.domain.Fish;
import com.puc.tcc.repository.FishRepository;

@Stateless
public class FishServiceImpl implements FishService {

	@EJB
	private FishRepository fishRepository;

	@Override
	public List<Fish> findAll() {
		return fishRepository.findAll();
	}

}

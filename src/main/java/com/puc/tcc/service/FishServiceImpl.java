package com.puc.tcc.service;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.puc.tcc.domain.Fish;
import com.puc.tcc.dto.FishDTO;
import com.puc.tcc.repository.FishRepository;

@Stateless
public class FishServiceImpl implements FishService {

	@EJB
	private FishRepository fishRepository;

	@Override
	public Set<FishDTO> findAll() {
		Set<Fish> fishs = fishRepository.findAll();
		return fishs.parallelStream().map(FishDTO::of).collect(CopyOnWriteArraySet::new, Set::add, Set::addAll);
	}

}

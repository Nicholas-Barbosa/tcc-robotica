package com.puc.tcc.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
	public List<FishDTO> findAll() {
		List<Fish> fishs = fishRepository.findAll();
		return fishs.parallelStream().map(FishDTO::of).collect(CopyOnWriteArrayList::new, List::add, List::addAll);
	}

}

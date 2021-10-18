package com.puc.tcc.repository;

import java.util.Optional;

import com.puc.tcc.domain.Aquarium;

public interface AquariumRepository extends CrudRepository<Aquarium, Integer> {

	@Override
	default Optional<Aquarium> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

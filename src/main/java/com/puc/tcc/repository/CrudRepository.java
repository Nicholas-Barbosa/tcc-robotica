package com.puc.tcc.repository;

import java.util.Optional;
import java.util.Set;

import com.puc.tcc.domain.JpaEntity;

public interface CrudRepository<T extends JpaEntity, ID> {

	Set<T> findAll();

	T save(T t);

	Optional<T> findById(ID id);
}

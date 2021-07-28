package com.puc.tcc.service;

import com.puc.tcc.dto.CarDto;
import com.puc.tcc.dto.CarFormDTO;

public interface CarCrudService {

	CarDto save(CarFormDTO car);
}

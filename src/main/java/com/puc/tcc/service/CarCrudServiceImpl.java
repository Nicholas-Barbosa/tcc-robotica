package com.puc.tcc.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.puc.tcc.domain.Car;
import com.puc.tcc.dto.CarDto;
import com.puc.tcc.dto.CarFormDTO;
import com.puc.tcc.repository.CarCrudRepository;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CarCrudServiceImpl implements CarCrudService {

	@EJB
	private CarCrudRepository carRepository;

	@Override
	public CarDto save(CarFormDTO car) {
		Car transientCar = new Car(car.getName(), car.getCreatedAt());
		return CarDto.ofCar(carRepository.save(transientCar));
	}

}

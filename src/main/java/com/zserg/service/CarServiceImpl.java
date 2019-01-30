package com.zserg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zserg.dao.CarDAO;
import com.zserg.model.Car;

@Service
@Transactional
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CarDAO carDAO;

	public void addCar(Car car) {
		carDAO.addCar(car);
	}

	public List<Car> getCars() {
		return carDAO.getCars();
	}

}

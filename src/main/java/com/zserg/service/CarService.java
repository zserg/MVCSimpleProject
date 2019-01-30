package com.zserg.service;

import java.util.List;

import com.zserg.model.Car;

public interface CarService {
	
	public void addCar(Car car);
	public List<Car> getCars();

}

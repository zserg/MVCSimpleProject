package com.zserg.dao;

import java.util.List;

import com.zserg.model.Car;

public interface CarDAO {

	public void addCar(Car car);
	public List<Car> getCar();

}

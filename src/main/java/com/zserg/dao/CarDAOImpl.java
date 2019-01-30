package com.zserg.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zserg.model.Car;

@Repository
public class CarDAOImpl implements CarDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addCar(Car car) {
		getCurrentSession().save(car);
	}

	@SuppressWarnings("unchecked")
	public List<Car> getCars() {
		return getCurrentSession().createQuery("from Car").list();
	}

}

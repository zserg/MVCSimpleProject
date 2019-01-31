package com.zserg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zserg.model.Car;
import com.zserg.service.CarService;

@Controller
public class LinkController {

	@Autowired
	private CarService carService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("car", new Car());
		List<Car> cars = carService.getCar();
		modelAndView.addObject("cars", cars);
		return modelAndView;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView addingCar(@ModelAttribute Car car) {

		ModelAndView modelAndView = new ModelAndView("home");
		carService.addCar(car);

		String message = "Car was successfully added.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("car", new Car());
		List<Car> cars = carService.getCar();
		modelAndView.addObject("cars", cars);

		return modelAndView;
	}

}

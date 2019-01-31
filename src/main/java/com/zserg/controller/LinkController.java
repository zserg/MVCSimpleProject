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
	private CarService deviceService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView mainPage() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("device", new Car());
		List<Car> cars = deviceService.getCar();
		modelAndView.addObject("cars", cars);
		return modelAndView;
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView addingDevice(@ModelAttribute Car device) {

		ModelAndView modelAndView = new ModelAndView("home");
		deviceService.addCar(device);

		String message = "Car was successfully added.";
		modelAndView.addObject("message", message);
		modelAndView.addObject("device", new Car());
		List<Car> cars = deviceService.getCar();
		modelAndView.addObject("cars", cars);

		return modelAndView;
	}

}

package com.zserg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zserg.model.Car;
import com.zserg.service.CarService;

@Controller
@RequestMapping(value="/car")
public class DeviceController {

	@Autowired
	private CarService deviceService;

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addDevicePage() {
		ModelAndView modelAndView = new ModelAndView("add-device-form");
		modelAndView.addObject("car", new Car());
		return modelAndView;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingDevice(@ModelAttribute Car device) {

		ModelAndView modelAndView = new ModelAndView("home");
		deviceService.addCar(device);

		String message = "Device was successfully added.";
		modelAndView.addObject("message", message);

		return modelAndView;
	}

	@RequestMapping(value="/list")
	public ModelAndView listOfDevices() {
		ModelAndView modelAndView = new ModelAndView("list-of-devices");

		List<Car> devices = deviceService.getCar();
		modelAndView.addObject("devices", devices);

		return modelAndView;
	}



}

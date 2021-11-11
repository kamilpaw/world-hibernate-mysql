package com.kpaw.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpaw.world.entity.City;
import com.kpaw.world.service.CityService;

@Controller
@RequestMapping("/cities")
public class CityController {

	private CityService cityService;
	
	public CityController(CityService theCityService) {
		cityService = theCityService;
	}
	
	@GetMapping("/list")
	public String showCities(Model theModel) {
		List<City> theCities = cityService.findAll();
		theModel.addAttribute("cities", theCities);
		return "cities/list-cities";
	}
}

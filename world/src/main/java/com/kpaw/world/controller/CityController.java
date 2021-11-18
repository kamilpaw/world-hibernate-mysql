package com.kpaw.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/search")
	public String search(@RequestParam("name") String theName,
						@RequestParam("country") String theCountry,
						Model theModel
						) {
		if (theName.trim().isEmpty() && theCountry.isEmpty()) {
			return "redirect:/cities/list";
		}else {
		List<City> theCities = cityService.searchBy(theName, theCountry);
		theModel.addAttribute("cities", theCities);
		return "cities/list-cities";
		}
	}
	
	@GetMapping("/orderByName")
	public String sortByName(Model theModel) {
		List<City> theCities = cityService.orderByName();
		theModel.addAttribute("cities", theCities);
		return "cities/list-cities";
	}
	
	@GetMapping("/orderByCountry")
	public String sortByCountry(Model theModel) {
		List<City> theCities = cityService.orderByCountry();
		theModel.addAttribute("cities", theCities);
		return "cities/list-cities";
	}
		
		
	@GetMapping("/orderByPopulation")
	public String sortByPopulation(Model theModel) {
		List<City> theCities = cityService.orderByPopulation();
		theModel.addAttribute("cities", theCities);
		return "cities/list-cities";
	}
}








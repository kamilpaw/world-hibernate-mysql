package com.kpaw.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kpaw.world.entity.City;
import com.kpaw.world.entity.Country;
import com.kpaw.world.service.CityService;
import com.kpaw.world.service.CountryService;

@Controller
@RequestMapping("/cities")
public class CityController {

	private CityService cityService;
	private CountryService countryService;

	public CityController(CityService theCityService, CountryService theCountryService) {
		this.cityService = theCityService;
		this.countryService = theCountryService;
	}

	@GetMapping("/list")
	public String showCities(Model theModel) {
		List<City> theCities = cityService.findAll();
		theModel.addAttribute("cities", theCities);
		return "cities/list-cities";
	}
	
	@GetMapping("/addCity")
	public String addCityForm() {
		return "cities/city-form";
	}
	
	@GetMapping("/updateCity")
	public String updateCityForm(@RequestParam("cityId") int theId, Model theModel) {
		City theCity = cityService.findById(theId);
		theModel.addAttribute("city", theCity);
		return "cities/cityUpdate-form";
	}
	
	@GetMapping("/deleteCity")
	public String deleteCityById(@RequestParam("cityId") int theId) {
		cityService.deleteCityById(theId);
		return "redirect:/cities/list";
	}

	@GetMapping("/search")
	public String search(@RequestParam("name") String theName, @RequestParam("country") String theCountry,
			Model theModel) {
		if (theName.trim().isEmpty() && theCountry.isEmpty()) {
			return "redirect:/cities/list";
		} else {
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
	
	@PostMapping("/saveCity")
	public String saveCity(@RequestParam("name") String theName, @RequestParam("countryCode") String theCountryCode,
			@RequestParam("district") String theDistrict, @RequestParam("population") int thePopulation) {
		Country theCountry = countryService.findById(theCountryCode);
		City theCity = new City(theName, theCountry, theDistrict, thePopulation);
		cityService.save(theCity);
		return "redirect:/cities/list";
	}
	
	@PostMapping("/saveUpdatedCity")
	public String saveUpdatedCity(@ModelAttribute("city") City theCity) {
		cityService.save(theCity);
		return "redirect:/cities/list";
	}
	
}


































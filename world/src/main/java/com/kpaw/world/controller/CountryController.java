package com.kpaw.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpaw.world.entity.Country;
import com.kpaw.world.service.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {
	
	private CountryService countryService;
	
	private CountryController(CountryService theCountryService) {
		countryService = theCountryService;
	}
	
	@GetMapping("/list")
	public String showCountries(Model theModel) {
		List<Country> theCountries = countryService.findAll();
		theModel.addAttribute("countries", theCountries);
		return "countries/list-countries";
	}
	
}

package com.kpaw.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kpaw.world.entity.CountryLanguage;
import com.kpaw.world.service.CountryLanguageService;

@Controller
@RequestMapping("/languages")
public class CountryLanguageController {

	private CountryLanguageService countryLanguageService;
	
	public CountryLanguageController(CountryLanguageService theCountryLanguageService) {
		countryLanguageService = theCountryLanguageService;
	}
	
	@GetMapping("/list")
	public String showCountryLanguages(Model theModel) {
		List<CountryLanguage> countryLanguages = countryLanguageService.findAll();
		theModel.addAttribute("languages", countryLanguages);
		return "/languages/list-languages";
	}
}

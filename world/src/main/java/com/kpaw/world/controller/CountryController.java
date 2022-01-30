package com.kpaw.world.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		Country theCountry = countryService.findById("POL");
		return "countries/list-countries";
	}

	@GetMapping("/search")
	public String search(@RequestParam("code") String theCode, @RequestParam("name") String theName,
			@RequestParam("region") String theRegion, Model theModel) {

		if (theCode.trim().isEmpty() && theName.trim().isEmpty() && theRegion.trim().isEmpty()) {
			return "redirect:/countries/list";
		} else {
			List<Country> theCountries = countryService.searchBy(theCode, theName, theRegion);
			theModel.addAttribute("countries", theCountries);
			return "countries/list-countries";
		}
	}

	@GetMapping("/advSearch")
	public String advSearch(@RequestParam("name") String theName, @RequestParam("region") String theRegion,
			@RequestParam("surfaceFrom") String theSurfaceFrom, @RequestParam("surfaceTo") String theSurfaceTo,
			@RequestParam("indFrom") String theIndFrom, @RequestParam("indTo") String theIndTo,
			@RequestParam("popFrom") String thePopFrom, @RequestParam("popTo") String thePopTo,
			@RequestParam("liExFrom") String theLiExFrom, @RequestParam("liExTo") String theLiExTo, Model theModel) {

		if (theName.trim().isEmpty() && theRegion.trim().isEmpty() && theSurfaceFrom.trim().isEmpty()
				&& theSurfaceTo.trim().isEmpty() && theIndFrom.trim().isEmpty() && theIndTo.trim().isEmpty()
				&& thePopFrom.trim().isEmpty() && thePopTo.trim().isEmpty() && theLiExFrom.trim().isEmpty()
				&& theLiExTo.trim().isEmpty()) {
			return "redirect:/countries/list";

		} else {

			try {
				List<Country> theCountries = countryService.advancedSearch(theName, theRegion, theSurfaceFrom,
						theSurfaceTo, theIndFrom, theIndTo, thePopFrom, thePopTo, theLiExFrom, theLiExTo);
				theModel.addAttribute("countries", theCountries);
				return "countries/list-countries";

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return "countries/advanced-search";
		}

	}

	@GetMapping("/sortByRegion")
	public String sortByRegion(Model theModel) {
		List<Country> theCountries = countryService.orderByRegion();
		theModel.addAttribute("countries", theCountries);
		return "countries/list-countries";
	}

	@GetMapping("sortByName")
	public String sortByName(Model theModel) {
		List<Country> theCountries = countryService.orderByName();
		theModel.addAttribute("countries", theCountries);
		return "countries/list-countries";
	}

	@GetMapping("/sortBySurface")
	public String sortBySurface(Model theModel) {
		List<Country> theCountries = countryService.orderBySurface();
		theModel.addAttribute("countries", theCountries);
		return "countries/list-countries";
	}

	@GetMapping("/sortByCode")
	public String sortByCode(Model theModel) {
		List<Country> theCountries = countryService.orderByCode();
		theModel.addAttribute("countries", theCountries);
		return "countries/list-countries";
	}

	@GetMapping("/advSearchSite")
	public String advSearchSite() {
		return "countries/advanced-search";
	}
}

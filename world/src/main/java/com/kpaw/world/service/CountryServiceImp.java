package com.kpaw.world.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpaw.world.dao.CountryRepository;
import com.kpaw.world.entity.Country;

@Service
public class CountryServiceImp implements CountryService {
	
	private CountryRepository countryRepository;
	
	@Autowired
	public CountryServiceImp(CountryRepository theCountryRepository) {
		countryRepository = theCountryRepository; 
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public List<Country> searchBy(String theCode, String theName, String theRegion) {
		return countryRepository.findByCodeContainsAndNameContainsAndRegionContainsAllIgnoreCase(theCode, theName, theRegion);
	}

	@Override
	public List<Country> orderByRegion() {
		return countryRepository.findAllByOrderByRegionAsc();
	}

	@Override
	public List<Country> orderByName() {
		return countryRepository.findAllByOrderByNameAsc();
	}

	@Override
	public List<Country> orderBySurface() {
		return countryRepository.findAllByOrderBySurfaceAreaAsc();
	}

	@Override
	public List<Country> orderByCode() {
		return countryRepository.findAllByOrderByCodeAsc();
	}


}

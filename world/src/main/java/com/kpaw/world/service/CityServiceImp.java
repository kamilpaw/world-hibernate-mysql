package com.kpaw.world.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpaw.world.dao.CityRepository;
import com.kpaw.world.entity.City;

@Service
public class CityServiceImp implements CityService{
	
	private CityRepository cityRepository;

	@Autowired
	public CityServiceImp(CityRepository theCityRepository) {
		this.cityRepository = theCityRepository;
		
	}
	
	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public List<City> searchBy(String theName, String theCountry) {
		return cityRepository.findByNameContainsAndCountryNameContainsAllIgnoreCase
				(theName, theCountry);
	}

	@Override
	public List<City> orderByName() {
		return cityRepository.findAllByOrderByNameAsc();
	}

	@Override
	public List<City> orderByCountry() {
		return cityRepository.findAllByOrderByCountryNameAsc();
	}

	@Override
	public List<City> orderByPopulation() {
		return cityRepository.findAllByOrderByPopulationAsc();
	}

}

package com.kpaw.world.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpaw.world.dao.CityRepository;
import com.kpaw.world.entity.City;

@Service
public class CityServiceImp implements CityService {

	private final CityRepository cityRepository;

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
		return cityRepository.findByNameContainsAndCountryNameContainsAllIgnoreCase(theName, theCountry);
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

	@Override
	public void save(City theCity) {
		cityRepository.save(theCity);

	}

	@Override
	public void deleteCityById(int theId) {
		cityRepository.deleteById(theId);
	}

	@Override
	public City findById(int theId) {
		Optional<City> result = cityRepository.findById(theId);
		City theCity;
		if (result.isPresent()) {
			theCity = result.get();
		} else {
			throw new RuntimeException("Did not find city id: " + theId);
		}

		return theCity;
	}

}

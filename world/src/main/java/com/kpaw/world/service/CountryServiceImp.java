package com.kpaw.world.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpaw.world.dao.CountryRepository;
import com.kpaw.world.entity.Country;

@Service
public class CountryServiceImp implements CountryService {

	private final CountryRepository countryRepository;

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
		return countryRepository.findByCodeContainsAndNameContainsAndRegionContainsAllIgnoreCase(theCode, theName,
				theRegion);
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

	@Override
	public List<Country> advancedSearch(String theName, String theRegion, String surfaceFrom, String surfaceTo,
			String indFrom, String indTo, String popFrom, String popTo, String liExFrom, String liExTo) {
			Double theSurfaceFrom = Double.valueOf(surfaceFrom);
			Double theSurfaceTo = Double.valueOf(surfaceTo);
			Short theIndFrom = Short.valueOf(indFrom);
			Short theIndTo = Short.valueOf(indTo);
			Integer thePopFrom = Integer.valueOf(popFrom);
			Integer thePopTo = Integer.valueOf(popTo);
			Double theLiExFrom = Double.valueOf(liExFrom);
			Double theLiExTo = Double.valueOf(liExTo);
			return countryRepository
					.findByNameContainsAndRegionContainsAndSurfaceAreaGreaterThanEqualAndSurfaceAreaLessThanEqualAndIndepYearGreaterThanEqualAndIndepYearLessThanEqualAndPopulationGreaterThanEqualAndPopulationLessThanEqualAndLifeExpectancyGreaterThanEqualAndLifeExpectancyLessThanEqual(
							theName, theRegion, theSurfaceFrom, theSurfaceTo, theIndFrom, theIndTo, thePopFrom,
							thePopTo, theLiExFrom, theLiExTo);
	}

	@Override
	public Country findById(String theCountryCode) {
		Optional<Country> result = countryRepository.findById(theCountryCode);
		Country theCountry;
		if (result.isPresent()) {
			theCountry = result.get();
		} else {
			throw new RuntimeException("Did not find country code - " + theCountryCode);
		}

		return theCountry;
	}

}

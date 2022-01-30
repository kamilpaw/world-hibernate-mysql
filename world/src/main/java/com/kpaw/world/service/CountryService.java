package com.kpaw.world.service;

import java.util.List;

import com.kpaw.world.entity.Country;

public interface CountryService {

	List<Country> findAll();

	List<Country> searchBy(String theCode, String theName, String theRegion);

	List<Country> orderByRegion();

	List<Country> orderByName();

	List<Country> orderBySurface();

	List<Country> orderByCode();

	List<Country> advancedSearch(String theName, String theRegion, String surfaceFrom, String surfaceTo,
			String indFrom, String indTo, String popFrom, String popTo, String liExFrom, String liExTo);

	Country findById(String theCountryCode);
}

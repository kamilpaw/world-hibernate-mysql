package com.kpaw.world.service;

import java.util.List;

import com.kpaw.world.entity.Country;

public interface CountryService {

	public List<Country> findAll();
	
	public List<Country> searchBy(String theCode, String theName, String theRegion);
}

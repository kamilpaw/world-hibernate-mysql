package com.kpaw.world.service;

import java.util.List;

import com.kpaw.world.entity.CountryLanguage;

public interface CountryLanguageService {
	
	public List<CountryLanguage> findAll();
	
	public List<CountryLanguage> searchBy(String theLanguage, String theCountry);
}

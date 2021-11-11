package com.kpaw.world.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpaw.world.dao.CountryLanguageRepository;
import com.kpaw.world.entity.CountryLanguage;

@Service
public class CountryLanguageServiceImp implements CountryLanguageService{

private CountryLanguageRepository countryLanguageRepository;

@Autowired
public CountryLanguageServiceImp(CountryLanguageRepository theCountryLanguageRepository) {
	this.countryLanguageRepository = theCountryLanguageRepository;
}

	@Override
	public List<CountryLanguage> findAll() {
		return countryLanguageRepository.findAll();
	}

}

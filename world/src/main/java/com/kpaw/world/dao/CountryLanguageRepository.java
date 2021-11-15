package com.kpaw.world.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.CountryLanguage;
import com.kpaw.world.entity.CountryLanguageKey;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {

	public List<CountryLanguage> findByLanguageContainsAndCountryCodeNameContainsAllIgnoreCase
	(String theLanguage, String theCountry);
	

}

package com.kpaw.world.entity;

import java.io.Serializable;

public class CountryLanguageKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private Country countryCode;
	private String language;
	
	public CountryLanguageKey() {
		
	}

	public CountryLanguageKey(Country countryCode, String language) {
		this.countryCode = countryCode;
		this.language = language;
	}

	public Country getCountryCode() {
		return countryCode;
	}

	public String getLanguage() {
		return language;
	}

}

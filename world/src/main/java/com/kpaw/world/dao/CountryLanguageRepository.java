package com.kpaw.world.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.CountryLanguage;
import com.kpaw.world.entity.CountryLanguageKey;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {

}

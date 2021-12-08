package com.kpaw.world.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

	public List<Country> findByCodeContainsAndNameContainsAndRegionContainsAllIgnoreCase(String theCode, String theName,
			String theRegion);

	public List<Country> findAllByOrderByRegionAsc();

	public List<Country> findAllByOrderByNameAsc();

	public List<Country> findAllByOrderBySurfaceAreaAsc();

	public List<Country> findAllByOrderByCodeAsc();

	public List<Country> findByNameContainsAndRegionContainsAndSurfaceAreaGreaterThanEqualAndSurfaceAreaLessThanEqualAndIndepYearGreaterThanEqualAndIndepYearLessThanEqualAndPopulationGreaterThanEqualAndPopulationLessThanEqualAndLifeExpectancyGreaterThanEqualAndLifeExpectancyLessThanEqual(
			String theName, String theRegion, Double theSurfaceFrom, Double theSurfaceTo, Short theIndFrom,
			Short theIndTo, Integer thePopFrom, Integer thePopTo, Double theLiExFrom, Double theLiExTo);

}

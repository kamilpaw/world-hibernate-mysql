package com.kpaw.world.dao;

import com.kpaw.world.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

	List<Country> findByCodeContainsAndNameContainsAndRegionContainsAllIgnoreCase(String theCode, String theName,
			String theRegion);

	List<Country> findAllByOrderByRegionAsc();

	List<Country> findAllByOrderByNameAsc();

	List<Country> findAllByOrderBySurfaceAreaAsc();

	List<Country> findAllByOrderByCodeAsc();

	List<Country> findByNameContainsAndRegionContainsAndSurfaceAreaGreaterThanEqualAndSurfaceAreaLessThanEqualAndIndepYearGreaterThanEqualAndIndepYearLessThanEqualAndPopulationGreaterThanEqualAndPopulationLessThanEqualAndLifeExpectancyGreaterThanEqualAndLifeExpectancyLessThanEqual(
			String theName, String theRegion, Double theSurfaceFrom, Double theSurfaceTo, Short theIndFrom,
			Short theIndTo, Integer thePopFrom, Integer thePopTo, Double theLiExFrom, Double theLiExTo);

}

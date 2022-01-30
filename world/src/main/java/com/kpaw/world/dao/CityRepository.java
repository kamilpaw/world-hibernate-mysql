package com.kpaw.world.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByNameContainsAndCountryNameContainsAllIgnoreCase(String theName, String theCountry);

	List<City> findAllByOrderByNameAsc();

	List<City> findAllByOrderByCountryNameAsc();

	List<City> findAllByOrderByPopulationAsc();

}

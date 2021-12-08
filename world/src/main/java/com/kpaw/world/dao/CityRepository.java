package com.kpaw.world.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	public List<City> findByNameContainsAndCountryNameContainsAllIgnoreCase(String theName, String theCountry);

	public List<City> findAllByOrderByNameAsc();

	public List<City> findAllByOrderByCountryNameAsc();

	public List<City> findAllByOrderByPopulationAsc();

}

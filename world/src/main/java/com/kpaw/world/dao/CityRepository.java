package com.kpaw.world.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

}

package com.kpaw.world.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kpaw.world.entity.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}

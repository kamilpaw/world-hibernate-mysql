package com.kpaw.world.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "Name")
	private String name;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "CountryCode")
	private Country country;

	@Column(name = "District")
	private String district;

	@Column(name = "Population")
	private Integer population;
	
	public City() {
		
	}

	public City(Integer id, String name, Country country, String district, Integer population) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.district = district;
		this.population = population;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public String getDistrict() {
		return district;
	}

	public Integer getPopulation() {
		return population;
	}

}
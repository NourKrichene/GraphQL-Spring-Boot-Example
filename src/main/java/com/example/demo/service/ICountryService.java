package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Country;

public interface ICountryService {

	Country saveCountry(Country country);

	Country getCountryById(Long id);

	void deleteCountryById(Long id);

	List<Country> findAll();

	List<Country> findByName(String name);
}

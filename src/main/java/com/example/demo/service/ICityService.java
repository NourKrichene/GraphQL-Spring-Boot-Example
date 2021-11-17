package com.example.demo.service;

import java.util.List;

import com.example.demo.model.City;

public interface ICityService {

	City saveCity(City city);

	City getCityById(Long id);

	void deleteCityById(Long id);

	List<City> findAll();

	List<City> findByName(String name);
}

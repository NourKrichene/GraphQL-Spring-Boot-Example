package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.City;
import com.example.demo.service.ICityService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class CityResolver implements GraphQLQueryResolver {

	@Autowired
	private ICityService cityService;

	public City city(Long id) {
		return cityService.getCityById(id);
	}

	public List<City> allCities() {
		return cityService.findAll();
	}

	public List<City> citiesByName(String name) {
		return cityService.findByName(name);
	}

}

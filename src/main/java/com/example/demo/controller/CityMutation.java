package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.City;
import com.example.demo.service.ICityService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class CityMutation implements GraphQLMutationResolver {
	@Autowired
	private ICityService cityService;

	public City addCity(String name, int population) {
		City city = new City();
		city.setName(name);
		city.setPopulation(population);
		return cityService.saveCity(city);
	}

	public String deleteCity(Long id) {
		cityService.deleteCityById(id);
		return "City deleted";
	}
}

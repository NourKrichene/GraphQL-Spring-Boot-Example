package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.ICityService;
import com.example.demo.service.ICountryService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class CountryMutation implements GraphQLMutationResolver {
	@Autowired
	private ICountryService countryService;
	@Autowired
	private ICityService cityService;

	public Country addCountry(String name, String language) {
		Country country = new Country();
		country.setName(name);
		country.setLanguage(language);
		countryService.saveCountry(country);
		return country;
	}

	public Country addCountryWithCapital(String name, String language, City capital) {
		Country country = new Country();
		country.setName(name);
		country.setLanguage(language);
		country = countryService.saveCountry(country);
		City city = cityService.getCityById(capital.getId());
		if (city != null) {
			country.setCapital(city);
		} else {
			country.setCapital(cityService.saveCity(capital));
		}
		return countryService.saveCountry(country);
	}

	public String deleteCountry(Long id) {
		countryService.deleteCountryById(id);
		return "Country deleted";
	}

	public Country setCapital(Long countryId, Long cityId) {
		Country country = countryService.getCountryById(countryId);
		country.setCapital(cityService.getCityById(cityId));
		return countryService.saveCountry(country);
	}

}

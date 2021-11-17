package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.City;
import com.example.demo.repository.CityRepository;

@Service
public class CityService implements ICityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public List<City> findByName(String name) {
		return cityRepository.findByName(name);
	}

	@Override
	public City saveCity(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City getCityById(Long id) {
		return cityRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteCityById(Long id) {
		cityRepository.deleteById(id);
	}

}

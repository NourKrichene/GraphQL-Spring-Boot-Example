package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

	@Override
	List<City> findAll();

	List<City> findByName(String name);
}
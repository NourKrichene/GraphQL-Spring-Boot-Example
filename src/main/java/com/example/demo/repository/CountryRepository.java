package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

	@Override
	List<Country> findAll();

	List<Country> findByName(String name);
}
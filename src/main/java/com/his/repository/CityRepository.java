package com.his.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	public List<City> findByStateId(Integer stateId);

}

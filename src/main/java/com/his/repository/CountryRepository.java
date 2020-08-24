package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}

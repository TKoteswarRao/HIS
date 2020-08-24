package com.his.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.entity.Country;
import com.his.model.User;
import com.his.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository repo;

	@Override
	public Map<Integer, String> getAllCountry() {
		Map<Integer, String> mapCountry = new HashMap<Integer, String>();
		List<Country> listConuntry = repo.findAll();
		listConuntry.forEach(con -> {
			mapCountry.put(con.getCountryId(), con.getCountryName());
		});

		return mapCountry;
	}

}

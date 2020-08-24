package com.his.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.entity.City;
import com.his.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository repo;

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		List<City> listcity = repo.findByStateId(stateId);
		listcity.forEach(city -> {
			cityMap.put(city.getCityId(), city.getCityName());
		});
		return cityMap;
	}

}

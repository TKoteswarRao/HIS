package com.his.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.entity.Country;
import com.his.entity.State;
import com.his.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository repo;

	@Override
	public Map<Integer, String> getState(Integer countryId) {
		Map<Integer, String> stateMap = new HashMap<Integer, String>();
		List<State> listState = repo.findByCountryId(countryId);
		listState.forEach(state -> {
			stateMap.put(state.getStateId(), state.getStateName());
		});
		return stateMap;
	}

}

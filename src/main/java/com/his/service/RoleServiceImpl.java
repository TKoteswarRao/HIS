package com.his.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.entity.RoleEntity;
import com.his.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Map<Integer, String> getAllRole() {
		Map<Integer, String> roles = new HashMap<Integer, String>();
		List<RoleEntity> roleEntities = roleRepository.findAll();
		roleEntities.forEach(role -> {
			roles.put(role.getRoleId(), role.getRole());
		});
		return roles;
	}
}

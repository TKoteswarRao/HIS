package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
}

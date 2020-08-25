package com.his.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	public UserEntity findByEmail(String email);
}

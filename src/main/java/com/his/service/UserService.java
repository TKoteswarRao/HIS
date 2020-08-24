package com.his.service;

import java.util.List;

import com.his.model.User;

public interface UserService {
	boolean saveUser(User user);

	List<User> getAllUser();

	User getUserByEmail(String email);

	User getUserById(Integer cid);

	boolean updateUser(User c);

	boolean deleteUser(Integer cid);
}

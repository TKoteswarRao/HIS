package com.his.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.his.constant.AppConstant;
import com.his.entity.UserEntity;
import com.his.model.User;
import com.his.repository.UserRepository;
import com.his.utils.EmailUtils;
import com.his.utils.PasswordGenerator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveUser(User user) {
		user.setUserPWD(PasswordGenerator.generateRandomPassword(AppConstant.TEMP_PWD_LENGTH));
		user.setAccStatus(AppConstant.LOCKED);

		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);

		UserEntity savedUser = repo.save(entity);

		if (savedUser.getUserId() != null) {
			emailUtils.sendUserAccountUnlockEmail(user);
		}
		return false;
	}

	@Override
	public List<User> getAllUser() {
		List<UserEntity> listUserEntity = repo.findAll();
		List<User> users = listUserEntity.stream().map(entity -> {
			User user = new User();
			BeanUtils.copyProperties(listUserEntity, user);
			return user;
		}).collect(Collectors.toList());
		return users;
	}

	@Override
	public User getUserById(Integer cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser(User c) {

		return false;
	}

	@Override
	public boolean deleteUser(Integer cid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByEmail(String email) {
		System.out.println("UserServiceImpl.findByUserEmail()" + email);
		User user = new User();
		UserEntity userEntity = repo.findByUserEmail(email);
		BeanUtils.copyProperties(userEntity, user);
		System.out.println("UserServiceImpl.findByUserEmail()" + user);
		return user;
	}

}

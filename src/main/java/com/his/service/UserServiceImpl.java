package com.his.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveUser(User user) {
		user.setPassword(PasswordGenerator.generateRandomPassword(AppConstant.TEMP_PWD_LENGTH));
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
//		List<User> users = listUserEntity.stream().map(entity -> {
//			User user = new User();
//			BeanUtils.copyProperties(listUserEntity, user);
//			return user;
//		}).collect(Collectors.toList());
		List<User> copy = new ArrayList<User>();
		for (UserEntity userEntity : listUserEntity) {
			User user = new User();
			BeanUtils.copyProperties(userEntity, user);
			copy.add(user);
		}
		return copy;
	}

	@Override
	public User getUserById(Integer uId) {
		Optional<UserEntity> optional = repo.findById(uId);
		UserEntity userEntity = optional.get();
		User user = new User();
		BeanUtils.copyProperties(userEntity, user);
		return user;
	}

	@Override
	public boolean updateUser(User user) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		UserEntity updatedUser = repo.save(entity);
		BeanUtils.copyProperties(updatedUser, user);
		log.info("Updateduser: " + updatedUser);
		return true;
	}

	@Override
	public boolean deleteUser(Integer cid) {
		repo.deleteById(cid);
		return true;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		UserEntity userEntity = repo.findByEmail(email);
		BeanUtils.copyProperties(userEntity, user);
		return user;
	}

}

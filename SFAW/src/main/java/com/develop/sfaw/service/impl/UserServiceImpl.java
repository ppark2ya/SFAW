package com.develop.sfaw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.develop.sfaw.persistence.UserDAO;
import com.develop.sfaw.repository.UserAPI;
import com.develop.sfaw.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource(name = "userDAO")
	private UserDAO userDao;

	@Override
	public UserAPI getUserInfo(String id) {
		return userDao.getUserInfo(id);
	}

	@Override
	public String createUser(UserAPI vo) {
		return userDao.createUser(vo);
	}




}

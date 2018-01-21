package com.develop.sfaw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develop.sfaw.persistence.UserDAO;
import com.develop.sfaw.repository.UserVO;
import com.develop.sfaw.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO dao;

	@Override
	public UserVO getUser() {

		return dao.getUser();
	}




}

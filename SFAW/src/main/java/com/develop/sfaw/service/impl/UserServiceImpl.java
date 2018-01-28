package com.develop.sfaw.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.develop.sfaw.common.CommonConstants;
import com.develop.sfaw.persistence.UserMapper;
import com.develop.sfaw.repository.UserAPI;
import com.develop.sfaw.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Inject
	private UserMapper userMapper;

	@Override
	public UserAPI getUserInfo(String id) {
		return userMapper.getUserInfo(id);
	}

	@Override
	public String createUser(UserAPI vo) {
		int result = userMapper.createUser(vo);
		if(result != 0) {
			return CommonConstants.SUCCESS;
		}else {
			return CommonConstants.FAIL;
		}
	}




}

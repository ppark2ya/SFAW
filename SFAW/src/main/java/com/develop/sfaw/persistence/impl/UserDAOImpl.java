package com.develop.sfaw.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.develop.sfaw.common.CommonConstrants;
import com.develop.sfaw.persistence.UserDAO;
import com.develop.sfaw.repository.UserAPI;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SqlSession session;

	@Override
	public UserAPI getUserInfo(String id) {
		return session.selectOne("user.getUserInfo", id);
	}

	@Override
	@Transactional
	public String createUser(UserAPI vo) {
		int result = session.insert("user.createUser", vo);
		if(result != 0) {
			return CommonConstrants.SUCCESS;
		}else {
			return CommonConstrants.FAIL;
		}
	}
}

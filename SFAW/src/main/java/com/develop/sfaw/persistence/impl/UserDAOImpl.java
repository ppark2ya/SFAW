package com.develop.sfaw.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.develop.sfaw.persistence.UserDAO;
import com.develop.sfaw.repository.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SqlSession session;

	@Override
	public UserVO getUser() {
		UserVO vo = session.selectOne("user.getUser");
		return vo;
	}
}

package com.develop.sfaw.persistence;

import com.develop.sfaw.repository.UserAPI;

public interface UserMapper {
	public int createUser(UserAPI vo);
	public UserAPI getUserInfo(String id);
}

package com.develop.sfaw.persistence;

import com.develop.sfaw.repository.UserAPI;

public interface UserDAO {
	public String createUser(UserAPI vo);
	public UserAPI getUserInfo(String id);
}

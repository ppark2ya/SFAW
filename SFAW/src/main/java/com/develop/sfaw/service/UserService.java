package com.develop.sfaw.service;

import com.develop.sfaw.repository.UserAPI;

public interface UserService {
	public UserAPI getUserInfo(String id);
	public String checkId(String id);
	public String createUser(UserAPI vo);
}

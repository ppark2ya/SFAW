package com.develop.sfaw.persistence;

import java.util.List;
import java.util.Map;

import com.develop.sfaw.repository.NoticeAPI;

public interface NoticeMapper {
	public List<NoticeAPI> getNotiList(Map<String, Object> params);
	public int totalRows();
	public void insertTest(int i);
}

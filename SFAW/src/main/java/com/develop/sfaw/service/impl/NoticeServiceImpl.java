package com.develop.sfaw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.develop.sfaw.persistence.NoticeMapper;
import com.develop.sfaw.repository.NoticeAPI;
import com.develop.sfaw.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	@Inject
	private NoticeMapper notiMapper;

	@Override
	@Transactional
	public Map<String, Object> getNotiList(Map<String, Object> params) {
		List<NoticeAPI> list = notiMapper.getNotiList(params);
		Map<String, Object> resultMap = new HashMap<>();
		return null;
	}

}

package com.develop.sfaw.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.sfaw.service.NoticeService;
import com.develop.sfaw.service.impl.NoticeServiceImpl;

@RestController
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger log = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Resource(name = "noticeService")
	private NoticeService notiService;

	@GetMapping("/getNotiList/{pageNum}")
	public Map<String, Object> getNotiList(@PathVariable Integer pageNum) {
		int logCount = 1;
		log.info("NOTICE LISTEN-{}.", logCount++);
		Map<String, Object> map = new HashMap<>();
		return notiService.getNotiList(pageNum);
	}
}

package com.develop.sfaw.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develop.sfaw.service.NoticeService;
import com.develop.sfaw.util.PageUtil;

@RestController
@RequestMapping("/notice")
public class NoticeController {

	@Resource(name = "noticeService")
	private NoticeService notiService;

	@GetMapping("/getNotiList/{pageNum}")
	public Map<String, Object> getNotiList(@PathVariable Integer pageNum) {
		Map<String, Object> map = new HashMap<>();
		notiService.getNotiList(map);
		return map;
	}
}

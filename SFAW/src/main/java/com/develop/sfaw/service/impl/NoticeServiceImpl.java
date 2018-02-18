package com.develop.sfaw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.develop.sfaw.common.CommonConstants;
import com.develop.sfaw.persistence.NoticeMapper;
import com.develop.sfaw.repository.NoticeAPI;
import com.develop.sfaw.service.NoticeService;
import com.develop.sfaw.util.PageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{

	private static final Logger log = LoggerFactory.getLogger(NoticeServiceImpl.class);

	@Inject
	private NoticeMapper notiMapper;

	@Override
	@Transactional
	public Map<String, Object> getNotiList(Integer pageNum) {
		int logCount = 1;
		Map<String, Object> param = new HashMap<>();
		Map<String, Object> resultMap = new HashMap<>();
		param.put("pageNum", (pageNum - 1) * CommonConstants.VIEW_ROWS);
		param.put("viewRows", CommonConstants.VIEW_ROWS);

		try {
			log.info("NOTICE LIST START-{}.", logCount++);
			List<NoticeAPI> list = notiMapper.getNotiList(param);

			if(list.isEmpty()) {
				resultMap.put("resultCd", CommonConstants.FAIL);
				log.info("NOTICE LIST IS EMPTY!!-{}. RESULT CODE: {}.", logCount++, resultMap.get("resultCd"));
			}else {
				resultMap.put("resultCd", CommonConstants.SUCCESS);
				resultMap.put("notiList", list);
				log.info("GET NOTICE LIST!!-{}. RESULT CODE: {}.", logCount++, resultMap.get("resultCd"));
				int totalRows = notiMapper.totalRows();
				log.info("TOTAL ROWS : {}", totalRows);
				PageUtil pageInfo =
						PageUtil.Builder()
						.totalRows(totalRows)
						.viewRows(CommonConstants.VIEW_ROWS)
						.pageDisplay(CommonConstants.PAGE_DISPLAY)
						.currentPage(pageNum)
						.totalPages()
						.totalBlock()
						.block()
						.firstPage()
						.lastPage()
						.prevPage()
						.nextPage()
						.build();
				ObjectMapper mapper = new ObjectMapper();
				String resultData = mapper.writeValueAsString(pageInfo);
				log.info("NOTICE LIST-{}. PAGE INFO : {}", logCount++, resultData);
				resultMap.put("pageInfo", pageInfo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultMap;
	}

}

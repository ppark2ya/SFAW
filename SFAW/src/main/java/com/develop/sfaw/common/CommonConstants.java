package com.develop.sfaw.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonConstants {
	/**
	 *  성공, 실패 코드
	 */
	public static final String SUCCESS = "SUCCESS";
	public static final String FAIL = "FAIL";
	/**
	 *  현재 시간
	 */
	public static final String CURRENT_DATE
					= new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
	public static final String CURRENT_TIME
					= new SimpleDateFormat("HHmmss").format(new Date(System.currentTimeMillis()));
	/**
	 *  csv 테이블 생성 자동화 코드
	 */
	public static final String TABLE_NAME = "TABLE_NAME";
	public static final String NUMBER = "NUMBER";
	public static final String COLUMN_NAME = "COLUMN_NAME";
	public static final String KEY = "KEY";
	public static final String DEFAULT_VALUE = "DEFAULT_VALUE";
	public static final String NULL_TYPE = "NULL_TYPE";
	public static final String VALUE_TYPE = "VALUE_TYPE";
	public static final String DETAIL = "DETAIL";
	/**
	 *  페이징 관련 변수
	 */
	public static final Integer PAGE_DISPLAY = 5;
	public static final Integer VIEW_ROWS = 10;
}

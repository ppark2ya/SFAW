package com.develop.sfaw.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.develop.sfaw.common.CommonConstants;
import com.develop.sfaw.util.DBConnect;

@Service
public class DBInsertTest {

	private static final Logger log = LoggerFactory.getLogger(DBInsertTest.class);

	public static void main(String[] args) {
		noticeInsert();
	}

	@Transactional
	public static void noticeInsert() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int logCount = 1;
		log.info("Notice Insert Test Start-{}.", (logCount++));

		try {
			conn = new DBConnect().getConn();
			for(int i = 1; i <= 100; i++) {
				StringBuilder noticeInsertSQL = new StringBuilder();
				noticeInsertSQL.append("INSERT INTO tb_notice");
				noticeInsertSQL.append("(title, noti, writer, enabled, reg_dt, reg_tm, upd_dt, upd_tm) ");
				noticeInsertSQL.append("VALUES('제목" + i + "',");
				noticeInsertSQL.append("'내용" + i + "',");
				noticeInsertSQL.append("'test',");
				noticeInsertSQL.append("'1',");
				noticeInsertSQL.append("'" + CommonConstants.CURRENT_DATE + "',");
				noticeInsertSQL.append("'" + CommonConstants.CURRENT_TIME + "',");
				noticeInsertSQL.append("'" + CommonConstants.CURRENT_DATE + "',");
				noticeInsertSQL.append("'" + CommonConstants.CURRENT_TIME + "')");
				pstmt = conn.prepareStatement(noticeInsertSQL.toString());
				pstmt.executeUpdate();
			}
			log.info("Notice Insert Test End-{}.", logCount++);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

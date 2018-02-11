package com.develop.sfaw.sql;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.develop.sfaw.common.CommonConstants;
import com.develop.sfaw.util.DBConnect;

public class MysqlTableCreate {

	private static final Logger log = LoggerFactory.getLogger(MysqlTableCreate.class);

	public static void main(String[] args){
		parseCsvFile("C:\\Users\\ppark\\git\\SFAW\\SFAW\\src\\main\\java\\com\\develop\\sfaw\\sql\\SFAW.csv", "UTF-8");
	}

	public static void parseCsvFile(String path, String encoding) {
		BufferedReader br = null;
		String line;
		String csvSplitBy = ",";
		// 하나의 컬럼 정보를 저장할 list
		List<Map<String, String>> columns = new ArrayList<>();
		try {
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(path), encoding));
			while ((line = br.readLine()) != null) {
				// 필요없는 라인 건너뛰기
				if(line.contains("타입,내용")) {
					continue;
				}
				// 각 coulmn에 필요한 값을 저장할 map
				Map<String, String> params = new HashMap<>();
				String field[] = line.split(csvSplitBy);
				// table명 저장
				if(line.contains("테이블") && line.contains("tb_")) {
					for(String data : field) {
						if(data.contains("tb_")) {
							params.put(CommonConstants.TABLE_NAME, data);
							columns.add(params);
							break;
						}
					}
				// 1개 테이블 생성 완료
				}else if(field.length == 0) {
					createTable(columns);
					// 1개의 테이블정보 갱신
					columns.clear();
					continue;
				// 실제 값 저장
				}else {
					params.put(CommonConstants.NUMBER, field[0]);
					params.put(CommonConstants.COLUMN_NAME, field[1]);
					params.put(CommonConstants.KEY, field[2]);
					params.put(CommonConstants.DEFAULT_VALUE, field[3]);
					params.put(CommonConstants.NULL_TYPE, field[4]);
					params.put(CommonConstants.VALUE_TYPE, field[5]);
					if(line.contains("auto_increment") || line.contains("references")) {
						for(String data : field) {
							if(data.contains("auto_increment")) {
								params.put(CommonConstants.DETAIL, data);
							}
							if(data.contains("references")) {
								params.put(CommonConstants.DETAIL, data);
							}
						}
					}
					columns.add(params);
				}
			}
		} catch(FileNotFoundException fe) {
			log.info("FILE NOT FOUND MESSAGE : {}", fe.getMessage());
			fe.printStackTrace();
		} catch(IOException ie) {
			log.info("IOEXCEPTION MESSAGE : {}", ie.getMessage());
			ie.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void createTable(List<Map<String, String>> columns) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		Map<String, String> entity;
		int logCount = 1;
		log.info("Create Table Start-{}. Table Name : {}", (logCount++), columns.get(0).get(CommonConstants.TABLE_NAME));

		StringBuilder createTableSQL = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
		createTableSQL.append(columns.get(0).get(CommonConstants.TABLE_NAME) + "(");

		for(int i = 1; i < columns.size(); i++) {
			entity = columns.get(i);
			createTableSQL.append(entity.get(CommonConstants.COLUMN_NAME) + " ");
			createTableSQL.append(entity.get(CommonConstants.VALUE_TYPE) + " ");

			if(entity.get(CommonConstants.KEY).length() == 0
					&& entity.get(CommonConstants.NULL_TYPE).length() == 0
					&& entity.get(CommonConstants.DEFAULT_VALUE).length() == 0) {
				if(columns.size()-1 == i) continue;
				createTableSQL.append(",");
				continue;
			}

			if(entity.get(CommonConstants.KEY).length() != 0) {
				// pk 일 때
				if(entity.get(CommonConstants.KEY).equals("pk")) {
					if(entity.containsKey(CommonConstants.DETAIL)
							&& entity.get(CommonConstants.DETAIL).contains("auto_increment")) {
						createTableSQL.append(entity.get(CommonConstants.DETAIL) + " ");
					}
					createTableSQL.append("primary key, ");
					continue;
				// fk 일 때
				}else {
					if(entity.get(CommonConstants.NULL_TYPE).length() != 0) {
						createTableSQL.append(entity.get(CommonConstants.NULL_TYPE) + " ");
					}
					if(entity.containsKey(CommonConstants.DETAIL)
							&& entity.get(CommonConstants.DETAIL).contains("references")) {
						createTableSQL.append(entity.get(CommonConstants.DETAIL) + ", ");
						continue;
					}
				}
			}

			if(entity.get(CommonConstants.DEFAULT_VALUE).length() != 0) {
				createTableSQL.append("DEFAULT '" + entity.get(CommonConstants.DEFAULT_VALUE) + "', ");
				continue;
			}

			if(entity.get(CommonConstants.NULL_TYPE).length() != 0) {
				if(columns.size()-1 == i) {
					createTableSQL.append(entity.get(CommonConstants.NULL_TYPE));
					break;
				}
				createTableSQL.append(entity.get(CommonConstants.NULL_TYPE) + ", ");
				continue;
			}

		}
		createTableSQL.append(")");
		try {
			conn = new DBConnect().getConn();
			pstmt = conn.prepareStatement(createTableSQL.toString());
			pstmt.executeUpdate();
			log.info("Table " + columns.get(0).get(CommonConstants.TABLE_NAME) + " is created!");
			log.info("Create Table End-{}.", logCount++);
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

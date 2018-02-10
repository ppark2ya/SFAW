package com.develop.sfaw.sql;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.develop.sfaw.util.DBConnect;

public class MysqlTableCreate {

	private static final Logger log = LoggerFactory.getLogger(MysqlTableCreate.class);

	public static void main(String[] args){
		BufferedReader br = null;
		String line;
		String csvSplitBy = ",";
		Map<String, String> params = new HashMap<>();
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\ppark\\git\\SFAW\\SFAW\\src\\main\\java\\com\\develop\\sfaw\\sql\\SFAW.csv"), "UTF-8"));
			while ((line = br.readLine()) != null) {
				if(line.contains("번호")) {
					continue;
				}

				String field[] = line.split(csvSplitBy);
				for(String data : field) {
					if(data.contains("tb_")) {
						params.put("tableName", data);
						break;
					}
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

	public static void createTable(Map<String, String> parmas) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		try {
			conn = new DBConnect().getConn();
			sql.append("CREATE TABLE IF NOT EXISTS(");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

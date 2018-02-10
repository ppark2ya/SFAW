package com.develop.sfaw.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.develop.sfaw.sql.MysqlTableCreate;

public class DBConnect {

	private static final Logger log = LoggerFactory.getLogger(MysqlTableCreate.class);
	private Connection conn;

	public DBConnect() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/sfaw?useSSL=false&amp;allowMultiQueries=true";
			conn = DriverManager.getConnection(url, "root", "!@whdxo258");
			log.info("DB Connection SUCCESS!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
}

package com.kh.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate { 
//	1. Connection 객체 생성 후 Connection 을 반환하는 메서드
	public static Connection getConnection() {
//		Propertice
		Properties prop = new Properties();

//		읽어들이고자 하는 driver.properties 파일의 물리적인 경로 제시

		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
		System.out.println(fileName);

		try {
			prop.load(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Connection conn = null;

		try {
//			1) jdbc driver 등록
			Class.forName(prop.getProperty("driver"));

//			2) db와 접속된 Connection 객체 생성
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"),
					prop.getProperty("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

//	2. 전달받은 JDBC용 객체를 반납시켜주는 메서드(객체별로 오버로딩)
//	2_1) Connection 객체를 전달받아서 반납시켜주는 메서드
	public static void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	2_2) Statement 객체를 전달받아서 반납시켜주는 메서드
	public static void close(Statement stmt) { // Statement, PreparedStatement 모두
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	2_3) ResultSet 객체를 전달맏아서 반납시켜주는 메서드
	public static void close(ResultSet rset) {
		try {
			rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	3) 전달받은 Connection 객체를 가지고 트랜잭션 처리를 해주는 메서드
//	3_1) Commit 메서드
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	3_2) rollback 메서드
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
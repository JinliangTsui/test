package com.ego.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbFactory {

	private Connection conn = getConnection();

	public Connection getConnection() {

		Connection conn = null;
		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://localhost:1433/EGoShopping", "sa", "");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean execSqlWithoutRS(String sql, Object[] params) {
		boolean flag = true;
		try {
			if (conn == null) {
				conn = getConnection();
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}

			pstmt.execute();
			this.close();
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;

	}

	public ResultSet execSqlWithRS(String sql, Object[] params) {
		ResultSet rs = null;

		try {
			if (conn == null) {
				conn = getConnection();
			}
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;

	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}

}

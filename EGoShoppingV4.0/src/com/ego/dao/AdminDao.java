package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.Admin;

public class AdminDao {
	private DbFactory dbf = new DbFactory();

	public String getAuthority(String adUserName) {
		String authority = "2";
		String sql = "select * from Admin where adUserName=?";
		Object[] params = { adUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				authority = rs.getString("adAuthority");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authority;
	}

	public ArrayList<Admin> getByAuthority() {
		ArrayList<Admin> al = new ArrayList<Admin>();
		String sql = "select * from Admin where adAuthority='1'";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setAdUserName(rs.getString("adUserName"));
				admin.setAdPassword(rs.getString("adPassword"));
				admin.setAdAuthority(rs.getString("adAuthority"));

				al.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public void insert(Admin admin) {
		String sql = "insert into Admin values(?,?,1)";
		Object[] params = { admin.getAdUserName(), admin.getAdPassword() };
		dbf.execSqlWithoutRS(sql, params);
	}

	// 检查用户名是否已存在，存在返回true，否则返回false
	public boolean checkName(String adUserName) {
		boolean flag = false;
		String sql = "select * from Admin where adUserName=?";
		Object[] params = { adUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean delete(String adUserName) {
		boolean flag = false;
		String sql = "delete from Admin where adUserName=?";
		Object[] params = { adUserName };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public Admin getByName(String adUserName) {
		Admin admin = new Admin();
		String sql = "select * from Admin where adUserName=?";
		Object[] params = { adUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				admin.setAdUserName(rs.getString("adUserName"));
				admin.setAdPassword(rs.getString("adPassword"));
				admin.setAdAuthority(rs.getString("adAuthority"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	public boolean modify(Admin admin) {
		boolean flag = false;
		String sql = "update Admin set adPassword=? where adUserName=?";
		Object[] params = { admin.getAdPassword(), admin.getAdUserName() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

}

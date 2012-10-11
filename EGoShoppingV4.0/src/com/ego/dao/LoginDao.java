package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ego.po.Admin;
import com.ego.po.Member;

public class LoginDao {
	private DbFactory dbf = new DbFactory();

	public boolean loginCheck(Member mem) {
		boolean flag = false;
		try {
			String sql = "select * from Member where memUserName=? and memPassword=?";
			Object[] params = { mem.getMemUserName(), mem.getMemPassword() };
			ResultSet rs = dbf.execSqlWithRS(sql, params);
			if (rs.next())
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean admin_LoginCheck(Admin admin) {
		boolean flag = false;
		try {
			String sql = "select * from Admin where adUserName=? and adPassword=?";
			Object[] params = { admin.getAdUserName(), admin.getAdPassword() };
			ResultSet rs = dbf.execSqlWithRS(sql, params);
			if (rs.next())
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public int getState(Member mem) {
		int state = 1;
		String sql = "select state from Member where memUserName=?";
		Object[] params = {mem.getMemUserName()};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while(rs.next()) {
				state = Integer.parseInt(rs.getString("state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return state;
	}


}

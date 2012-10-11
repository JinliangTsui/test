package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.RechargeRecord;

public class RechargeRecordDao {

	DbFactory dbf = new DbFactory();

	public ArrayList<RechargeRecord> getAll(String memUserName) {
		ArrayList<RechargeRecord> al = new ArrayList<RechargeRecord>();
		String sql = "select * from RechargeRecord where memUserName=?";
		Object[] params = { memUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				RechargeRecord rr = new RechargeRecord();
				rr.setRecId(rs.getInt("recId"));
				rr.setMemUserName(rs.getString("memUserName"));
				rr.setRechargeTime(rs.getTimestamp("rechargeTime"));
				rr.setRechargeAmount(rs.getBigDecimal("recharegeAmount"));

				al.add(rr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public boolean insert(RechargeRecord rr) {
		boolean flag = false;
		String sql = "insert into RechargeRecord values(?,?,?);";
		Object[] params = { rr.getMemUserName(), rr.getRechargeTime(),
				rr.getRechargeAmount()};
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

}

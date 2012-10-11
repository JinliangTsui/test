package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.AddressInfo;

public class AddressInfoDao {

	DbFactory dbf = new DbFactory();

	public ArrayList<AddressInfo> getAll(String memUserName) {
		ArrayList<AddressInfo> al = new ArrayList<AddressInfo>();
		String sql = "select * from AddressInfo where memUserName=?";
		Object[] params = { memUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				AddressInfo adrInfo = new AddressInfo();
				adrInfo.setAdrId(rs.getInt("adrId"));
				adrInfo.setMemUserName(rs.getString("memUserName"));
				adrInfo.setReceiverName(rs.getString("receiverName"));
				adrInfo.setReceiverTel(rs.getString("receiverTel"));
				adrInfo.setReceiverAdr(rs.getString("receiverAdr"));
				adrInfo.setZip(rs.getString("zip"));

				al.add(adrInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public AddressInfo getById(String memUserName, int adrId) {
		AddressInfo adrInfo = new AddressInfo();
		String sql = "select * from AddressInfo where adrId=? and memUserName=?";
		Object[] params = { adrId, memUserName };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				adrInfo.setAdrId(rs.getInt("adrId"));
				adrInfo.setMemUserName(rs.getString("memUserName"));
				adrInfo.setReceiverName(rs.getString("receiverName"));
				adrInfo.setReceiverTel(rs.getString("receiverTel"));
				adrInfo.setReceiverAdr(rs.getString("receiverAdr"));
				adrInfo.setZip(rs.getString("zip"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adrInfo;
	}

	public boolean insert(AddressInfo adrInfo) {
		boolean flag = false;
		String sql = "insert into AddressInfo values(?,?,?,?,?)";
		Object[] params = { adrInfo.getMemUserName(),
				adrInfo.getReceiverName(), adrInfo.getReceiverTel(),
				adrInfo.getReceiverAdr(), adrInfo.getZip() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public boolean modify(AddressInfo adrInfo) {
		boolean flag = false;
		String sql = "update AddressInfo set receiverName=?,receiverTel=?,receiverAdr=?,zip=? where adrId=? and memUserName=?";
		Object[] params = { adrInfo.getReceiverName(),
				adrInfo.getReceiverTel(), adrInfo.getReceiverAdr(),
				adrInfo.getZip(), adrInfo.getAdrId(), adrInfo.getMemUserName() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public boolean delete(int adrId, String memUserName) {
		boolean flag = false;
		String sql = "delete from AddressInfo where adrId=? and memUserName=?";
		Object[] params = { adrId, memUserName };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

}

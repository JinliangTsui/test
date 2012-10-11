package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.Commodity;

public class CommodityDao {
	private DbFactory dbf = new DbFactory();

	public ArrayList<Commodity> getAll() {
		ArrayList<Commodity> al = new ArrayList<Commodity>();
		String sql = "select * from Commodity";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Commodity comm = new Commodity();
				comm.setCommId(rs.getInt("commId"));
				comm.setSecCategoryId(rs.getInt("secCategoryId"));
				comm.setCommName(rs.getString("commName"));
				comm.setPrice(rs.getBigDecimal("price"));
				comm.setCommImg(rs.getString("commImg"));
				comm.setCommDesc(rs.getString("commDesc"));
				comm.setCommAmount(rs.getInt("commAmount"));
				comm.setSaledAmount(rs.getInt("saledAmount"));

				al.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	public boolean insert(Commodity comm) {
		String sql = "insert into Commodity values(?,?,?,?,?,?,0)";
		Object[] params = { comm.getSecCategoryId(), comm.getCommName(),
				comm.getPrice(), comm.getCommImg(), comm.getCommDesc(),
				comm.getCommAmount() };
		return dbf.execSqlWithoutRS(sql, params);
	}

	public boolean delete(int commId) {
		String sql = "delete from Commodity where commId=?";
		Object[] params = { commId };
		return dbf.execSqlWithoutRS(sql, params);
	}

	public boolean modify(Commodity comm) {

		String sql = "update Commodity set "
				+ "secCategoryId=?,commName=?,price=?,commImg=?,commDesc=?,commAmount=? where commId=?";
		Object[] params = { comm.getSecCategoryId(), comm.getCommName(),
				comm.getPrice(), comm.getCommImg(), comm.getCommDesc(),
				comm.getCommAmount(), comm.getCommId() };
		return dbf.execSqlWithoutRS(sql, params);
	}

	public Commodity getById(int commId) {
		Commodity comm = new Commodity();
		try {
			String sql = "select * from Commodity where commId=?";
			Object[] params = { commId };
			ResultSet rs = dbf.execSqlWithRS(sql, params);
			if (rs.next()) {
				comm.setCommId(rs.getInt("commId"));
				comm.setSecCategoryId(rs.getInt("secCategoryId"));
				comm.setCommName(rs.getString("commName"));
				comm.setPrice(rs.getBigDecimal("price"));
				comm.setCommImg(rs.getString("commImg"));
				comm.setCommDesc(rs.getString("commDesc"));
				comm.setCommAmount(rs.getInt("commAmount"));
				comm.setSaledAmount(rs.getInt("saledAmount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return comm;
	}

	public ArrayList<Commodity> getTopSix() {
		ArrayList<Commodity> al = new ArrayList<Commodity>();
		String sql = "select top 6 * from Commodity order by commId desc";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Commodity comm = new Commodity();
				comm.setCommId(rs.getInt("commId"));
				comm.setSecCategoryId(rs.getInt("secCategoryId"));
				comm.setCommName(rs.getString("commName"));
				comm.setPrice(rs.getBigDecimal("price"));
				comm.setCommImg(rs.getString("commImg"));
				comm.setCommDesc(rs.getString("commDesc"));
				comm.setCommAmount(rs.getInt("commAmount"));

				al.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}
	
	public ArrayList<Commodity> getAllBySecCtyId(int secCtyId) {
		ArrayList<Commodity> al = new ArrayList<Commodity>();
		String sql = "select top 6 * from Commodity where secCategoryId=? order by commId desc";
		Object[] params = {secCtyId};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				Commodity comm = new Commodity();
				comm.setCommId(rs.getInt("commId"));
				comm.setSecCategoryId(rs.getInt("secCategoryId"));
				comm.setCommName(rs.getString("commName"));
				comm.setPrice(rs.getBigDecimal("price"));
				comm.setCommImg(rs.getString("commImg"));
				comm.setCommDesc(rs.getString("commDesc"));
				comm.setCommAmount(rs.getInt("commAmount"));

				al.add(comm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	public boolean addSaledAmount(int commId, int number) {
		boolean flag = false;
		String sql = "update Commodity set saledAmount=saledAmount+? where commId=?";
		Object[] params = { number, commId };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
	
	public Commodity getTopOne() {
		Commodity comm  =new Commodity();
		String sql = "select top 1 * from Commodity order by saledAmount desc";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				comm.setCommId(rs.getInt("commId"));
				comm.setSecCategoryId(rs.getInt("secCategoryId"));
				comm.setCommName(rs.getString("commName"));
				comm.setPrice(rs.getBigDecimal("price"));
				comm.setCommImg(rs.getString("commImg"));
				comm.setCommDesc(rs.getString("commDesc"));
				comm.setCommAmount(rs.getInt("commAmount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comm;
	}
	
	public boolean reduceCommAmount(int commId, int number) {
		boolean flag = false;
		String sql = "update Commodity set commAmount=commAmount-? where commId=?";
		Object[] params = {number,commId};
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
	
	public int getCommAmount(int commId) {
		int commAmount=0;
		String sql = "select commAmount from Commodity where commId=?";
		Object[] params={commId};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while(rs.next()) {
				commAmount = rs.getInt("commAmount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commAmount;
	}

}

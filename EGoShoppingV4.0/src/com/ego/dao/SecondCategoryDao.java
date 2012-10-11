package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.SecondCategory;
import com.ego.vo.SecondCategoryVO;

public class SecondCategoryDao {
	private DbFactory dbf = new DbFactory();

	public ArrayList<SecondCategoryVO> getAll() {
		ArrayList<SecondCategoryVO> al = new ArrayList<SecondCategoryVO>();
		String sql = "SELECT s.secCategoryId, s.secCategoryDesc, c.categoryDesc "
				+ "FROM Category AS c INNER JOIN SecondCategory AS s ON c.categoryId = s.categoryId";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				SecondCategoryVO scv = new SecondCategoryVO();
				scv.setSecCategoryId(rs.getInt("secCategoryId"));
				scv.setSecCategoryDesc(rs.getString("secCategoryDesc"));
				scv.setCategoryDesc(rs.getString("categoryDesc"));

				al.add(scv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public boolean addSecCategory(SecondCategory sc) {
		boolean flag = false;
		String sql = "insert into SecondCategory values(?,?);";
		Object[] params = { sc.getCategoryId(), sc.getSecCategoryDesc() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public boolean delSecCategory(int secCategoryId) {
		boolean flag = false;
		String sql = "delete from SecondCategory where secCategoryId=?";
		Object[] params = { secCategoryId };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public SecondCategory getById(int secCategoryId) {
		SecondCategory sc = new SecondCategory();
		String sql = "select * from SecondCategory where secCategoryId=?";
		Object[] params = { secCategoryId };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				sc.setSecCategoryId(rs.getInt("secCategoryId"));
				sc.setCategoryId(rs.getInt("categoryId"));
				sc.setSecCategoryDesc(rs.getString("secCategoryDesc"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sc;
	}

	public boolean modSecCategory(SecondCategory sc) {
		boolean flag = false;
		String sql = "update SecondCategory set categoryId=?, secCategoryDesc=? where secCategoryId=?";
		Object[] params = { sc.getCategoryId(), sc.getSecCategoryDesc(),
				sc.getSecCategoryId() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
	
	public ArrayList<Integer> getSecCtyIdByCtyId(int ctyId) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		String sql="select secCategoryId from SecondCategory where categoryId=?";
		Object[] params={ctyId};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while(rs.next()) {
				int secCtyId = rs.getInt("secCategoryId");
				
				al.add(secCtyId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	

}

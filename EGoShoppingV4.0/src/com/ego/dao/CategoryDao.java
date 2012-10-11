package com.ego.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.ego.po.Category;

public class CategoryDao {
	DbFactory dbf = new DbFactory();
	
	public ArrayList<Category> getAll() {
		ArrayList<Category> al = new ArrayList<Category>();
		String sql = "select * from Category";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while(rs.next()) {
				Category c = new Category();
				c.setCategoryId(rs.getInt("categoryId"));
				c.setCategoryDesc(rs.getString("categoryDesc"));
				
				al.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}

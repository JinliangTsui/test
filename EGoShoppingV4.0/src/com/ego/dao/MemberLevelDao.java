package com.ego.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberLevelDao {

	DbFactory dbf = new DbFactory();

	public float getDiscountByName(BigDecimal money) {
		float discount = 1;
		String sql = "select * from MemberLevel";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				BigDecimal standard = rs.getBigDecimal("standard");
				if(money.compareTo(standard)==1){
					discount=rs.getFloat("discount");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return discount;
	}

}

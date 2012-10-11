package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.OrderCommodity;

public class OrderCommodityDao {

	DbFactory dbf = new DbFactory();

	public boolean insert(OrderCommodity oComm) {
		boolean flag = false;
		String sql = "insert into OrderCommodity values(?,?,?,?,?)";
		Object[] params = { oComm.getOrderId(), oComm.getCommodityName(),
				oComm.getCommodityPrice(), oComm.getCommodityAmount(),
				oComm.getCommodityId() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public ArrayList<OrderCommodity> getByOrderId(int orderId) {
		ArrayList<OrderCommodity> al = new ArrayList<OrderCommodity>();
		String sql = "select * from OrderCommodity where orderId = ?";
		Object[] params = { orderId };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				OrderCommodity oComm = new OrderCommodity();
				oComm.setItemNo(rs.getInt("itemNo"));
				oComm.setOrderId(rs.getInt("orderId"));
				oComm.setCommodityName(rs.getString("commodityName"));
				oComm.setCommodityPrice(rs.getBigDecimal("commodityPrice"));
				oComm.setCommodityAmount(rs.getInt("commodityAmount"));
				oComm.setCommodityId(rs.getInt("commodityId"));

				al.add(oComm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public boolean deleteByOrderId(int orderId) {
		boolean flag = false;
		String sql = "delete from OrderCommodity where orderId=?";
		Object[] params = { orderId };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

}

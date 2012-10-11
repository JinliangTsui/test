package com.ego.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ego.po.Order;

public class OrderDao {

	DbFactory dbf = new DbFactory();
	
	public ArrayList<Order> getAll() {
		ArrayList<Order> al = new ArrayList<Order>();
		String sql = "select * from [Order] order by orderId desc";
		Object[] params={};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while(rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setMemUserName(rs.getString("memUserName"));
				order.setAdrId(rs.getInt("adrId"));
				order.setOrderNote(rs.getString("orderNote"));
				order.setOrderState(rs.getString("orderState"));
				order.setOrderPayed(rs.getString("orderPayed"));
				
				al.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
	
	public ArrayList<Order> getAll(String memUserName) {
		ArrayList<Order> al = new ArrayList<Order>();
		String sql = "select * from [Order] where memUserName=? order by orderId desc";
		Object[] params={memUserName};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while(rs.next()) {
				Order order = new Order();
				order.setOrderId(rs.getInt("orderId"));
				order.setMemUserName(rs.getString("memUserName"));
				order.setAdrId(rs.getInt("adrId"));
				order.setOrderNote(rs.getString("orderNote"));
				order.setOrderState(rs.getString("orderState"));
				order.setOrderPayed(rs.getString("orderPayed"));
				
				al.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	public boolean generateOrder(Order order) {
		boolean flag = false;
		String sql = "insert into [Order] values(?,?,'已下单',?,'否')";
		Object[] params = { order.getMemUserName(), order.getAdrId(),
				order.getOrderNote() };
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

	public int getLatestOrderId() {
		int orderId = -1;
		String sql = "select top 1 orderId from [Order] order by orderId desc";
		Object[] params = {};
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				orderId = rs.getInt("orderId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderId;
	}

	public String getNoteById(int orderId) {
		String note = null;
		String sql = "select orderNote from [Order] where orderId=?";
		Object[] params = { orderId };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				note = rs.getString("orderNote");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return note;
	}

	public int getAdrIdByOrderId(int orderId) {
		int adrId = 0;
		String sql = "select adrId from [Order] where orderId=?";
		Object[] params = { orderId };
		ResultSet rs = dbf.execSqlWithRS(sql, params);
		try {
			while (rs.next()) {
				adrId = rs.getInt("adrId");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adrId;
	}
	
	public boolean changeOrderState(int orderId) {
		boolean flag = false;
		String sql="update [Order] set orderPayed='是' where orderId=?";
		Object[] params={orderId};
		flag = dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
	
	public boolean deleteById(int orderId) {
		boolean flag=false;
		String sql="delete from [Order] where orderId=?";		
		Object[] params={orderId};
		flag=dbf.execSqlWithoutRS(sql, params);
		return flag;
	}
	
	public boolean deliver(int orderId) {
		boolean flag =false;
		String sql="update [Order] set orderState='已发货' where orderId=?";
		Object[] params={orderId};
		flag=dbf.execSqlWithoutRS(sql, params);
		return flag;
	}

}

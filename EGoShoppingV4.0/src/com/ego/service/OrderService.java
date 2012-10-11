package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.OrderDao;
import com.ego.po.Order;

public class OrderService {
	
	OrderDao dao = new OrderDao();
	
	public boolean generateOrder(Order order) {
		return dao.generateOrder(order);
	}
	
	public int getLatestOrderId() {
		return dao.getLatestOrderId();
	}
	
	public String getNoteById(int orderId) {
		return dao.getNoteById(orderId);
	}
	
	public int getAdrIdByOrderId(int orderId) {
		return dao.getAdrIdByOrderId(orderId);
	}
	
	public ArrayList<Order> getAll(String memUserName) {
		return dao.getAll(memUserName);
	}
	
	public boolean changeOrderState(int orderId) {
		return dao.changeOrderState(orderId);
	}
	
	public boolean deleteById(int orderId) {
		return dao.deleteById(orderId);
	}
	
	public ArrayList<Order> getAll() {
		return dao.getAll();
	}
	
	public boolean deliver(int orderId) {
		return dao.deliver(orderId);
	}

}

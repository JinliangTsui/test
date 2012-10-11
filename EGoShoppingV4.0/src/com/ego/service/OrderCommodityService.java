package com.ego.service;

import java.util.ArrayList;

import com.ego.dao.OrderCommodityDao;
import com.ego.po.OrderCommodity;

public class OrderCommodityService {
	
	OrderCommodityDao dao = new OrderCommodityDao();
	
	public boolean insert(OrderCommodity oComm) {
		return dao.insert(oComm);
	}
	
	public ArrayList<OrderCommodity> getByOrderId(int orderId) {
		return dao.getByOrderId(orderId);
	}
	
	public boolean deleteByOrderId(int orderId) {
		return dao.deleteByOrderId(orderId);
	}

}

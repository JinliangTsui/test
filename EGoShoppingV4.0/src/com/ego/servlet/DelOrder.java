package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.service.OrderCommodityService;
import com.ego.service.OrderService;

public class DelOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int orderId =Integer.parseInt(request.getParameter("orderId"));
		OrderCommodityService ocService = new OrderCommodityService();
		ocService.deleteByOrderId(orderId);
		OrderService oService = new OrderService();
		oService.deleteById(orderId);
		if(request.getParameter("flag")!=null){
			request.getRequestDispatcher("orderManage.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("myOrder.jsp").forward(request, response);
		}
	}

}

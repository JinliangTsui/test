package com.ego.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Order;
import com.ego.po.OrderCommodity;
import com.ego.service.OrderCommodityService;
import com.ego.service.OrderService;
import com.ego.vo.SelectCommodity;

public class GenerateOrder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String memUserName = (String) session.getAttribute("username");
		int adrId = Integer.parseInt(request.getParameter("adrId"));
		String orderNote = request.getParameter("orderNote");
		
		Order order = new Order();
		order.setMemUserName(memUserName);
		order.setAdrId(adrId);
		order.setOrderNote(orderNote);
		OrderService oService = new OrderService();
		if(oService.generateOrder(order)) {
			int orderId = oService.getLatestOrderId();
			session.setAttribute("orderId", orderId);
			
			ArrayList<SelectCommodity> scAl = new ArrayList<SelectCommodity>();
			scAl = (ArrayList<SelectCommodity>) session
					.getAttribute("selectedComms");
			for (int i = 0; i < scAl.size(); i++) {
				SelectCommodity sc = scAl.get(i);
				String commodityName = request.getParameter(sc.getCommodity().getCommId().toString()+"_name");
				BigDecimal commodityPrice = new BigDecimal(request.getParameter(sc.getCommodity().getCommId().toString()+"_price"));
				int commodityAmount = Integer.parseInt(request.getParameter(sc.getCommodity().getCommId().toString()+"_number"));
				OrderCommodity oComm = new OrderCommodity();
				oComm.setOrderId(orderId);
				oComm.setCommodityName(commodityName);
				oComm.setCommodityPrice(commodityPrice);
				oComm.setCommodityAmount(commodityAmount);
				oComm.setCommodityId(sc.getCommodity().getCommId());
				OrderCommodityService ocService = new OrderCommodityService();
				ocService.insert(oComm);
			}
		}
		
		request.getRequestDispatcher("confirmOrder.jsp").forward(request, response);
		
	}

}

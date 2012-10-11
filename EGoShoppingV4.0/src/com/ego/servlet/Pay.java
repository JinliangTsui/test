package com.ego.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.OrderCommodity;
import com.ego.service.CommodityService;
import com.ego.service.MemberService;
import com.ego.service.OrderCommodityService;
import com.ego.service.OrderService;

public class Pay extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int orderId = (Integer) session.getAttribute("orderId");

		float total = 0;
		String memUserName = (String) session.getAttribute("username");
		OrderCommodityService ocService = new OrderCommodityService();
		OrderService oService = new OrderService();
		ArrayList<OrderCommodity> al = ocService.getByOrderId(orderId);
		CommodityService cService = new CommodityService();
		for (int i = 0; i < al.size(); i++) {
			OrderCommodity oComm = al.get(i);
			total = total
					+ (oComm.getCommodityPrice().floatValue() * oComm
							.getCommodityAmount());
		}
		MemberService mService = new MemberService();
		BigDecimal balance = mService.getBalanceByName(memUserName);
		if (balance.floatValue() - total >= 0) {
			mService.reduceBalance(new BigDecimal(total), memUserName);
			mService.addConsumeTotal(new BigDecimal(total), memUserName);
			oService.changeOrderState(orderId);
			for (int j = 0; j < al.size(); j++) {
				OrderCommodity newOComm = al.get(j);
				if(cService.getCommAmount(newOComm.getCommodityId())-newOComm.getCommodityAmount()<0){
					request.setAttribute("message", "库存不足，支付失败");
					request.getRequestDispatcher("fail.jsp").forward(request, response);
				}else{
					cService.reduceCommAmount(newOComm.getCommodityId(), newOComm.getCommodityAmount());
					cService.addSaledAmount(newOComm.getCommodityId(),
						newOComm.getCommodityAmount());
				}
				
			}
			session.setAttribute("selectedComms", null);
			request.getRequestDispatcher("success.jsp").forward(request,
					response);
		} else {
			request.setAttribute("message", "余额不足，支付失败");
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}

	}

}

package com.ego.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Commodity;
import com.ego.service.CommodityService;
import com.ego.vo.SelectCommodity;

public class BuyDirectly extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("loginSuccessFlag") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			ArrayList<SelectCommodity> scAl = new ArrayList<SelectCommodity>();
			int commId = Integer.parseInt(request.getParameter("commId"));
			CommodityService cService = new CommodityService();
			Commodity comm = cService.getById(commId);
			SelectCommodity sc = new SelectCommodity(comm);
			scAl.add(sc);
			session.setAttribute("selectedComms", scAl);
			request.getRequestDispatcher("shoppingCart.jsp?buyDirectly=1").forward(request, response);
		}
	}

}

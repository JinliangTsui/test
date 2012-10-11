package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Commodity;
import com.ego.service.CommodityService;
import com.ego.vo.SelectCommodity;

public class ModAmountInCart extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<SelectCommodity> scAl = new ArrayList<SelectCommodity>();
		ArrayList<SelectCommodity> newSCAl = new ArrayList<SelectCommodity>();
		HttpSession session = (HttpSession) request.getSession();
		scAl = (ArrayList<SelectCommodity>) session
				.getAttribute("selectedComms");
		SelectCommodity newSC = null;
		for (int i = 0; i < scAl.size(); i++) {
			SelectCommodity sc = scAl.get(i);
			int commId = Integer.parseInt(request.getParameter(sc
					.getCommodity().getCommId().toString()));
			int number = Integer.parseInt(request.getParameter(sc
					.getCommodity().getCommId().toString()
					+ "_number"));
			newSC = new SelectCommodity(sc.getCommodity());
			newSC.setNumber(number);
			newSCAl.add(newSC);
		}
		session.setAttribute("selectedComms", newSCAl);
		request.getRequestDispatcher("shoppingCart.jsp").forward(request,
				response);
	}

}

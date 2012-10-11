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
import com.ego.service.SecondCategoryService;

public class SearchByCategory extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Commodity> resultAl = new ArrayList<Commodity>();
		CommodityService cService = new CommodityService();
		if (request.getParameter("isSec") == null) {
			int ctyId = Integer.parseInt(request.getParameter("ctyId"));
			SecondCategoryService scService = new SecondCategoryService();
			ArrayList<Integer> secCtyIdAl = scService.getSecCtyIdByCtyId(ctyId);
			for (int i = 0; i < secCtyIdAl.size(); i++) {
				ArrayList<Commodity> commAl = cService
						.getAllBySecCtyId(secCtyIdAl.get(i));
				for (int j = 0; j < commAl.size(); j++) {
					resultAl.add(commAl.get(j));
				}
			}
		}else{
			int secCtyId = Integer.parseInt(request.getParameter("secCtyId"));
			resultAl = cService.getAllBySecCtyId(secCtyId);
		}
		HttpSession session = request.getSession();
		session.setAttribute("resultAl", resultAl);
		request.getRequestDispatcher("searchResult.jsp").forward(request,
				response);
	}

}

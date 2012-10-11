package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.service.CommodityService;

public class DelCommodity extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = "";
		CommodityService service = new CommodityService();
		
		int commId = Integer.parseInt(request.getParameter("commId"));
		String svrPath = getServletContext().getRealPath(getServletInfo())
				+ "\\images\\";
		System.out.println(svrPath);
		msg = service.deleteFile(svrPath, commId);
		
		request.setAttribute("message", msg);
		request.getRequestDispatcher("allCommodity.jsp").forward(request, response);
	}

}

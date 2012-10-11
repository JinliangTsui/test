package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.service.AddressInfoService;

public class DelAddressInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if(request.getParameter("username")==null){
			request.getRequestDispatcher("login.jsp").forward(request, response);			
		}else{
			int adrId = Integer.parseInt(request.getParameter("adrId"));
			String memUserName = request.getParameter("memUserName");
			
			AddressInfoService service = new AddressInfoService();
			if(service.delete(adrId, memUserName)) {
				request.setAttribute("message", "删除成功！ ");
				request.getRequestDispatcher("addressManage.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "删除失败！ ");
				request.getRequestDispatcher("addressManage.jsp").forward(request, response);
			}
		}
	}

}

package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Admin;
import com.ego.service.AdminService;

public class DelAdmin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("ad_loginSuccessFlag") == null) {
			request.getRequestDispatcher("admin_Login.jsp").forward(request,
					response);
		} else {
			String adUserName = request.getParameter("adUserName");
			AdminService service = new AdminService();
			if(service.delete(adUserName)){
				request.setAttribute("message", "删除成功");
				request.getRequestDispatcher("adminManage.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "删除失败");
				request.getRequestDispatcher("adminManage.jsp").forward(request, response);
			}
		}
	}

}

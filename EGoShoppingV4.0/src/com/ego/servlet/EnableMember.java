package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.service.MemberService;

public class EnableMember extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String memUsername = request.getParameter("memUsername");
		String currentPage = request.getParameter("page");
		MemberService service = new MemberService();
		service.enableMember(memUsername);
		request.setAttribute("page", currentPage);
		request.getRequestDispatcher("memberManage.jsp").forward(request, response);
	}

}

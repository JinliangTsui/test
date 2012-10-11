package com.ego.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.service.SecondCategoryService;

public class DelSecondCategory extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("ad_loginSuccessFlag") == null) {
			request.getRequestDispatcher("admin_Login.jsp").forward(request,
					response);
		} else {
			username = (String) session.getAttribute("ad_username");

			if (request.getParameter("id") == null) {
				request.getRequestDispatcher("categoryManage.jsp").forward(
						request, response);
			} else {
				int secCategoryId = Integer
						.parseInt(request.getParameter("id"));
				SecondCategoryService service = new SecondCategoryService();
				if (service.delSecCategory(secCategoryId)) {
					request.setAttribute("message", "删除成功");
					request.getRequestDispatcher("categoryManage.jsp").forward(
							request, response);
				} else {
					request.setAttribute("message", "删除失败");
					request.getRequestDispatcher("categoryManage.jsp").forward(
							request, response);
				}

			}
		}
	}
}

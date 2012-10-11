package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.SecondCategory;
import com.ego.service.SecondCategoryService;

public class AddSecondCategory extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String errorMsg = "";
		String username = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("ad_loginSuccessFlag") == null) {
			request.getRequestDispatcher("admin_Login.jsp").forward(request,
					response);
		} else {
			if (request.getParameter("secCategoryDesc") == ""
					|| request.getParameter("categoryId") == "") {
				errorMsg += "请输入二级目录名";
			}
			if (errorMsg == "") {
				String secCategoryDesc = request
						.getParameter("secCategoryDesc");
				int categoryId = Integer.parseInt(request
						.getParameter("categoryId"));

				SecondCategory sc = new SecondCategory();
				sc.setCategoryId(categoryId);
				sc.setSecCategoryDesc(secCategoryDesc);
				SecondCategoryService service = new SecondCategoryService();
				if (service.addSecCategory(sc)) {
					request.setAttribute("message", "添加成功");
					request.getRequestDispatcher("addSecCategory.jsp").forward(
							request, response);
				} else {
					request.setAttribute("message", "添加失败");
					request.getRequestDispatcher("addSecCategory.jsp").forward(
							request, response);
				}

			} else {
				request.setAttribute("message", errorMsg);
				request.getRequestDispatcher("addSecCategory.jsp").forward(
						request, response);
			}
		}
	}
}

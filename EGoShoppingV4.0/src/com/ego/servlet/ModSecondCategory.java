package com.ego.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.SecondCategory;
import com.ego.service.SecondCategoryService;

public class ModSecondCategory extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMsg = "";
		if (request.getParameter("secCategoryDesc") == "") {
			errorMsg += "目录名不能为空，请重新输入！";
		}
		HttpSession session = request.getSession();
		String username = null;
		int secCategoryId = Integer.parseInt(request
				.getParameter("secCategoryId"));
		String secCategoryDesc = request.getParameter("secCategoryDesc");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));

		if (session.getAttribute("ad_loginSuccessFlag") != null) {
			username = (String) session.getAttribute("ad_username");
			if (request.getParameter("secCategoryId") != null) {
				if (errorMsg == "") {
					SecondCategory sc = new SecondCategory();
					sc.setSecCategoryId(secCategoryId);
					sc.setSecCategoryDesc(secCategoryDesc);
					sc.setCategoryId(categoryId);

					SecondCategoryService service = new SecondCategoryService();
					if (service.modSecCategory(sc)) {
						request.setAttribute("message", "修改成功");
						request.getRequestDispatcher("categoryManage.jsp")
								.forward(request, response);
					} else {
						request.setAttribute("message", "修改失败");
						request.getRequestDispatcher("categoryManage.jsp")
								.forward(request, response);
					}

				} else {
					request.setAttribute("message", errorMsg);
					request.getRequestDispatcher(
							"modSecCategory.jsp?id=" + secCategoryId + "")
							.forward(request, response);
				}

			} else {
				request.getRequestDispatcher("categoryManage.jsp").forward(
						request, response);
			}

		} else {
			request.getRequestDispatcher("admin_Login.jsp").forward(request,
					response);
		}

	}

}

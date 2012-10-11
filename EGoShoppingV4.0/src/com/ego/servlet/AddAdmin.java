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

public class AddAdmin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("ad_loginSuccessFlag") == null) {
			request.getRequestDispatcher("admin_Login.jsp").forward(request,
					response);
		} else {
			if (request.getParameter("adUserName") == "") {
				msg += "账号不能为空！";
			}
			if (request.getParameter("adPassword") == "") {
				msg += "密码不能为空！";
			}
			if (!request.getParameter("adPassword").equals(
					request.getParameter("adPasswordCfg"))) {
				System.out.println(request.getParameter("adPassword"));
				System.out.println(request.getParameter("adPasswordCfg"));
				msg += "两次输入密码不一致！";
			}
			if (msg == "") {
				request.setAttribute("username",
						request.getParameter("username"));
				String adUserName = request.getParameter("adUserName");
				String adPassword = request.getParameter("adPassword");

				Admin admin = new Admin();
				admin.setAdUserName(adUserName);
				admin.setAdPassword(adPassword);

				AdminService service = new AdminService();
				if(service.checkName(adUserName)) {
					request.setAttribute("message", "用户名已存在，请重新输入！");
					request.getRequestDispatcher("addAdmin.jsp").forward(
							request, response);
				}else{
					service.insert(admin);

					request.setAttribute("message", "新增管理员成功!");
					request.getRequestDispatcher("addAdmin.jsp").forward(
							request, response);
				}
				
			} else {
				request.setAttribute("message", msg);
				request.getRequestDispatcher("addAdmin.jsp").forward(request,
						response);
			}
		}

	}

}

package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.po.Admin;
import com.ego.service.AdminService;

public class ModAdmin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg="";
		if(request.getParameter("username")==null){
			request.getRequestDispatcher("admin_Login").forward(request, response);			
		}else{
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
				if(service.modify(admin)) {
					request.setAttribute("message", "修改成功！");
					request.getRequestDispatcher("addAdmin.jsp").forward(
							request, response);
				}else{
					request.setAttribute("message", "修改失败！");
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

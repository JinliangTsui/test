package com.ego.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Admin;
import com.ego.po.Member;
import com.ego.service.LoginService;

public class Admin_LoginCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMsg = "";

		if (request.getParameter("username") == null
				|| request.getParameter("password") == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			if (request.getParameter("username") == "") {
				errorMsg += "用户名不能为空！<br>";
			}
			if (request.getParameter("password") == "") {
				errorMsg += "密码不能为空！<br>";
			}

			if (errorMsg == "") {
				String username = request.getParameter("username");
				String password = request.getParameter("password");

				Admin admin = new Admin();
				admin.setAdUserName(username);
				admin.setAdPassword(password);

				if (new LoginService().admin_LoginCheck(admin)) {
					
//					// 设置Cookie变量
//					if (request.getParameter("autoLogin") != null) {
//						Cookie c = new Cookie("LoginCheckPassed", "1");
//						c.setMaxAge(60 * 60);//时间单位是秒
//						response.addCookie(c);
//					}
					
					//设置强制登陆状态位
					HttpSession session = request.getSession();//获取从jsp页面传递过来的session对象
					session.setAttribute("ad_loginSuccessFlag", true);
					session.setAttribute("ad_username", username);
					
					//记录当前的操作时间
					session.setAttribute("ad_lastOperateTime", new Date().getTime());
					
					//重复登陆
					ServletContext app = getServletContext();
					session.setAttribute("ad_repeateLoginAccount", username);
					app.setAttribute(username, session.getId());
					

//					session.setAttribute("username", username);
					request.getRequestDispatcher("manage.jsp").forward(request,
							response);
				} else {
					request.setAttribute("message", "用户名或密码不正确，请重新输入！");
					request.getRequestDispatcher("admin_Login.jsp").forward(request,
							response);
				}
			} else {
				request.setAttribute("message", errorMsg);
				request.getRequestDispatcher("admin_Login.jsp").forward(request,
						response);
			}
		}
	}

}

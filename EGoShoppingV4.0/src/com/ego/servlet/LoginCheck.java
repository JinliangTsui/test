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
import javax.swing.JOptionPane;

import com.ego.po.Member;
import com.ego.service.LoginService;
import com.ego.util.MD5;

public class LoginCheck extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errorMsg = "";
		String validateC = ((String) request.getSession().getAttribute(
				"validateCode")).toLowerCase();
		String veryCode = request.getParameter("veryCode");

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
			if (veryCode == null || "".equals(veryCode)) {
				errorMsg+="验证码为空！<br>";
			} else {
				if (validateC.equals(veryCode)) {
				} else {
					errorMsg+="验证码错误！<br>";
				}
			}

			if (errorMsg == "") {
				String username = request.getParameter("username");
//				String password = request.getParameter("password");
				String password = new MD5().toMD5String(request
						.getParameter("password"));

				Member mem = new Member();
				mem.setMemUserName(username);
				mem.setMemPassword(password);

				if (new LoginService().loginCheck(mem)) {
					if (new LoginService().getState(mem) == 0) {
						request.setAttribute("message", "账号以被冻结，无法登陆！ ");
						request.getRequestDispatcher("login.jsp").forward(
								request, response);
					} else {
						// 设置Cookie变量
						if (request.getParameter("autoLogin") != null) {
							Cookie c = new Cookie("LoginCheckPassed", "1");
							c.setMaxAge(60 * 60);// 时间单位是秒
							response.addCookie(c);
						}

						// 设置强制登陆状态位
						HttpSession session = request.getSession();// 获取从jsp页面传递过来的session对象
						session.setAttribute("loginSuccessFlag", true);
						session.setAttribute("username", username);

						// 记录当前的操作时间
						session.setAttribute("lastOperateTime",
								new Date().getTime());

						// 重复登陆
						ServletContext app = getServletContext();
						session.setAttribute("repeateLoginAccount", username);
						app.setAttribute(username, session.getId());

						request.getRequestDispatcher("myEgo.jsp").forward(
								request, response);
					}
				} else {
					request.setAttribute("message", "用户名或密码不正确，请重新输入！");
					request.getRequestDispatcher("login.jsp").forward(request,
							response);
				}
			} else {
				request.setAttribute("message", errorMsg);
				request.getRequestDispatcher("login.jsp").forward(request,
						response);
			}
		}
	}

}

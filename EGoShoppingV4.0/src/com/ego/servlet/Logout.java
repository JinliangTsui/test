package com.ego.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取本机已有的所有Cookie变量
		Cookie[] cookies = request.getCookies();
		//判断Cookie变量是否是空值
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("VertifyPassed")) {
					cookies[i].setMaxAge(0);//通过设置生命周期为0，使得Cookie功能失效
					response.addCookie(cookies[i]);
				}
			}
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginSuccessFlag", null);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}

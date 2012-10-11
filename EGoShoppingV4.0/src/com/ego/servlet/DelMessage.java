package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ego.service.MessageService;

public class DelMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int msgId = Integer.parseInt(request.getParameter("msgId"));
		MessageService mService = new MessageService();
		mService.delete(msgId);
		request.getRequestDispatcher("messageManage.jsp").forward(request, response);
	}

}

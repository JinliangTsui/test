package com.ego.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Message;
import com.ego.service.MessageService;


public class AddMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String memUserName = (String)session.getAttribute("username");
		if(request.getParameter("msgContent")=="") {
			request.setAttribute("message", "请输入留言内容");
			request.getRequestDispatcher("contant.jsp").forward(request, response);
		}else {
			String msgContent = request.getParameter("msgContent");

			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");   
		    String msgTime = sdf.format(cal.getTime());
			
			Message msg = new Message();
			msg.setMemUserName(memUserName);
			msg.setMsgContent(msgContent);
			msg.setMsgTime(msgTime);
			
			MessageService mService = new MessageService();
			mService.insert(msg);
			
			request.getRequestDispatcher("myEgo.jsp").forward(request, response);
		}
	}

}

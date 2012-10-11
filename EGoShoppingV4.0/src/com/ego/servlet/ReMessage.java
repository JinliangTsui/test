package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.Message;
import com.ego.service.MessageService;

public class ReMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int msgId = Integer.parseInt(request.getParameter("msgId"));
		
		if(request.getParameter("reContent")=="") {
			request.setAttribute("message", "请输入回复内容");
			request.getRequestDispatcher("reMessage.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			String adUserName = (String)session.getAttribute("ad_username");
			String reContent = request.getParameter("reContent");
			
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");   
		    String reTime = sdf.format(cal.getTime());
		    
		    Message msg = new Message();
		    msg.setMsgId(msgId);
		    msg.setReContent(reContent);
		    msg.setAdUserName(adUserName);
		    msg.setReTime(reTime);
		    
		    MessageService mService = new MessageService();
		    mService.reMessage(msg);
		    
		    request.getRequestDispatcher("messageManage.jsp").forward(request, response);
		}
	}

}

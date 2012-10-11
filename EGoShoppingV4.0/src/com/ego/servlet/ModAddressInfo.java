package com.ego.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.AddressInfo;
import com.ego.service.AddressInfoService;

public class ModAddressInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg="";
		HttpSession session =request.getSession();
		if(session.getAttribute("loginSuccessFlag")==null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			if(request.getParameter("receiverName")==null) {
				msg+="请输入收货人姓名！";
			}
			if(request.getParameter("receiverTel")==null) {
				msg+="请输入收货人电话！";
			}
			if(request.getParameter("receiverTel").length() != 11) {
				msg+="请输入11位手机号！";
			}
			if(request.getParameter("receiverAdr")==null) {
				msg+="请输入收货人地址！";
			}
			if(request.getParameter("zip")==null) {
				msg+="请输入邮编！";
			}
			if(request.getParameter("zip").length() != 6) {
				msg+="请输入6位邮编！";
			}
			if(msg=="") {
				int adrId = Integer.parseInt(request.getParameter("adrId"));
				String memUserName = request.getParameter("memUserName");
				String receiverName = request.getParameter("receiverName");
				String receiverTel = request.getParameter("receiverTel");
				String receiverAdr = request.getParameter("receiverAdr");
				String zip = request.getParameter("zip");
				
				AddressInfoService service = new AddressInfoService();
				AddressInfo adrInfo = new AddressInfo();
				adrInfo.setAdrId(adrId);
				adrInfo.setMemUserName(memUserName);
				adrInfo.setReceiverName(receiverName);
				adrInfo.setReceiverTel(receiverTel);
				adrInfo.setReceiverAdr(receiverAdr);
				adrInfo.setZip(zip);
				if(service.modify(adrInfo)) {
					request.setAttribute("message", "修改成功！ ");
					request.getRequestDispatcher("modAddress.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "修改失败！ ");
					request.getRequestDispatcher("modAddress.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", msg);
				request.getRequestDispatcher("modAddress.jsp").forward(request, response);
			}
		}
	}

}

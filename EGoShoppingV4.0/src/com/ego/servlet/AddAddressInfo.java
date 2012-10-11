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

public class AddAddressInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = "";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginSuccessFlag") == null) {
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			if (request.getParameter("receiverName") == "") {
				msg += "请输入收货人姓名！ ";
			}
			if (request.getParameter("receiverTel") == "") {
				msg += "请输入收货人电话！ ";
			}
			if (request.getParameter("receiverAdr") == "") {
				msg += "请输入收货人地址！ ";
			}

			if (msg == "") {
				String memUserName = request.getParameter("memUserName");
				String receiverName = request.getParameter("receiverName");
				String receiverTel = request.getParameter("receiverTel");
				String receiverAdr = request.getParameter("receiverAdr");
				String zip = request.getParameter("zip");

				AddressInfo adrInfo = new AddressInfo();
				adrInfo.setMemUserName(memUserName);
				adrInfo.setReceiverName(receiverName);
				adrInfo.setReceiverTel(receiverTel);
				adrInfo.setReceiverAdr(receiverAdr);
				adrInfo.setZip(zip);

				AddressInfoService service = new AddressInfoService();
				if (service.insert(adrInfo)) {
					request.setAttribute("message", "操作成功！");
					request.getRequestDispatcher("addAddress.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "操作失败，请重试！");
					request.getRequestDispatcher("addAddress.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("message", msg);
				request.getRequestDispatcher("addAddress.jsp").forward(request, response);
			}

		}
	}
}

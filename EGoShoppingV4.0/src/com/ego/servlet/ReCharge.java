package com.ego.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ego.po.RechargeRecord;
import com.ego.service.RechargeRecordService;

public class ReCharge extends HttpServlet {

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
			if (request.getParameter("rechargeAmount") == "") {
				msg += "请输入充值金额";
			}
			if (msg == "") {
				String memUserName = request.getParameter("memUserName");
				BigDecimal rechargeAmount = new BigDecimal(
						request.getParameter("rechargeAmount"));
				// 获取当前系统时间
				Timestamp rechargeTime = null;

				try {
					SimpleDateFormat df = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					String time = df.format(new Date());
					Date dTime = df.parse(time);
					rechargeTime = new Timestamp(dTime.getTime());

				} catch (ParseException e) {
					e.printStackTrace();
				}

				RechargeRecord rr = new RechargeRecord();
				rr.setMemUserName(memUserName);
				rr.setRechargeTime(rechargeTime);
				rr.setRechargeAmount(rechargeAmount);

				RechargeRecordService service = new RechargeRecordService();
				if (service.insert(rr)
						&& service.recharge(memUserName, rechargeAmount)) {
					request.setAttribute("message", "充值成功！");
					request.getRequestDispatcher("reCharge.jsp").forward(
							request, response);
				} else {
					request.setAttribute("message", "充值失败！");
					request.getRequestDispatcher("reCharge.jsp").forward(
							request, response);
				}
			} else {
				request.setAttribute("message", msg);
				request.getRequestDispatcher("reCharge.jsp").forward(request,
						response);
			}
		}
	}

}
